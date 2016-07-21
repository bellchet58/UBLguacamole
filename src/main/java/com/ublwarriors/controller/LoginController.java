package com.ublwarriors.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ublwarriors.guacamole.model.UserWithBLOBs;
import com.ublwarriors.message.FailureValue;
import com.ublwarriors.message.MessageValue;
import com.ublwarriors.message.Quote;
import com.ublwarriors.message.UserValue;
import com.ublwarriors.util.PhaseDictionary;
import com.ublwarriors.util.SecurityTools;

@RestController
public class LoginController extends ServiceSupport {
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public Quote login(@RequestParam(value="username") String name, @RequestParam(value="password") String password, HttpServletRequest req)
	{
		logger.debug(""+userService.isExisted(name));
		if(!userService.isExisted(name))
		{
			Quote result = new Quote();
			result.setType(PhaseDictionary.FAILURE);
			result.setValue(new FailureValue(PhaseDictionary.FAIL_USERNOTEXISTED));
			return result;
		}else
		{
			Quote result = new Quote();
			UserWithBLOBs user = new UserWithBLOBs();
			user.setUsername(name);
			user = userService.selectUserByName(user);
			String stored = new String(user.getPasswordHash());
			try {
				if(SecurityTools.check(password,user.getPasswordHash(),user.getPasswordSalt()))
				{
					result.setType(PhaseDictionary.SUCCESS);
					result.setValue(new UserValue(user));
					req.getSession().setAttribute("userId", user.getUserId());
				}else{
					result.setType(PhaseDictionary.FAILURE);
					result.setValue(new FailureValue(PhaseDictionary.FAIL_AUTH));
				}
			} catch (Exception e) {
				logger.debug(e.getMessage());
				result.setType(PhaseDictionary.FAILURE);
				result.setValue(new FailureValue(PhaseDictionary.FAIL_USERNOTEXISTED));
			}
			return result;
		}
	}
	
	@RequestMapping(value="/logout")
	public Quote logout(HttpServletRequest req)
	{
		Quote result = new Quote();
		result.setType(PhaseDictionary.SUCCESS);
		req.getSession().removeAttribute("userId");
		req.getSession().removeAttribute("username");
		result.setValue(new MessageValue(PhaseDictionary.SUCCESS_LOGOUT));
		return result;
	}
}
