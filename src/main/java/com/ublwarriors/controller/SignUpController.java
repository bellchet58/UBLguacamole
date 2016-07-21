package com.ublwarriors.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ublwarriors.guacamole.model.User;
import com.ublwarriors.guacamole.model.UserWithBLOBs;
import com.ublwarriors.message.FailureValue;
import com.ublwarriors.message.Quote;
import com.ublwarriors.message.UserValue;
import com.ublwarriors.util.PhaseDictionary;
import com.ublwarriors.util.SecurityTools;

@RestController
public class SignUpController extends ServiceSupport{
	Logger logger =LoggerFactory.getLogger(SignUpController.class);
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public Quote signUp(@RequestParam(value="username") String name, @RequestParam(value="password") String password)
	{
		if(userService.isExisted(name))
		{
			Quote result = new Quote();
			result.setType(PhaseDictionary.FAILURE);
			result.setValue(new FailureValue(PhaseDictionary.FAIL_USEREXISTED));
			return result;
		}else{
			UserWithBLOBs user = new UserWithBLOBs();
			user.setUsername(name);
			Quote result = new Quote();
			try{
				user.setPasswordSalt(SecurityTools.getSalt());
				user.setPasswordHash(SecurityTools.hash(password, user.getPasswordSalt()));
				user = userService.addUser(user);
				result.setType(PhaseDictionary.SUCCESS);
				result.setValue(new UserValue(user));
			}catch(Exception e)
			{
				logger.debug(e.getMessage());
				result.setType(PhaseDictionary.FAILURE);
				result.setValue(new FailureValue(PhaseDictionary.FAIL_ADDUSER));
			}
			logger.debug("add user" +user.getUsername()+" "+ PhaseDictionary.SUCCESS);
			return result;
		}
		
	}
	

	
}
