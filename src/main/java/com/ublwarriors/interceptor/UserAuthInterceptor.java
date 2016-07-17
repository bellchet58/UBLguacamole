package com.ublwarriors.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ublwarriors.guacamole.model.User;
import com.ublwarriors.service.UserService;
import com.ublwarriors.util.PhaseDictionary;

public class UserAuthInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private UserService userService;
	
	Logger logger = LoggerFactory.getLogger(UserAuthInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user = new User();
		Integer userId = (Integer) request.getSession().getAttribute(PhaseDictionary.USERID);
		if(userId != null)
		{
			user.setUserId(userId);
			User temp = userService.selectUserById(user);
			if(temp!=null)
				return true;
			
		}
		response.setCharacterEncoding("utf-8");
        response.sendRedirect(request.getContextPath()+"/signup");
        logger.debug("拦截器正在工作");
		return super.preHandle(request, response, handler);
	}
	
}
