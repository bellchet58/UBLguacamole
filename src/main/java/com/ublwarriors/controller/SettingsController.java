package com.ublwarriors.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ublwarriors.dao.ActiveSession;
import com.ublwarriors.dao.ConnectionHistoryDao;
import com.ublwarriors.guacamole.model.Connection;
import com.ublwarriors.guacamole.model.User;
import com.ublwarriors.message.ListValue;
import com.ublwarriors.message.Quote;
import com.ublwarriors.message.UserValue;
import com.ublwarriors.util.PhaseDictionary;

@RestController
@RequestMapping("settings")
public class SettingsController extends ServiceSupport{
	@RequestMapping(value="activeSessions")
	public Quote getActiveSessions()
	{
		List<ActiveSession> sessions = historyService.getActiveSessionsList();
		Quote result = new Quote();
		result.setType(PhaseDictionary.SUCCESS);
		result.setValue(new ListValue<>(sessions));
		return result;
	}
	
	@RequestMapping(value="/filter/{filterType}")
	public Quote activeSessionFilter(@RequestParam String param, @PathVariable String filterType)
	{
		Quote result = new Quote();
		if(filterType.equals("activeSessions"))
		{
			List<ActiveSession> sessionsByUsername = userService.usernameFilter(param);
			List<ActiveSession> sessionsByStartDate = historyService.startDateFilter(param);
			List<ActiveSession> sessionByHost = connService.hostnameFilter(param);
			List<ActiveSession> sessionByConnName = connService.connectionNameFilter(param);
			sessionByConnName.addAll(sessionsByStartDate);
			sessionByConnName.addAll(sessionByHost);
			sessionByConnName.addAll(sessionByConnName);
			result.setType(PhaseDictionary.SUCCESS);
			result.setValue(new ListValue<>(sessionByConnName));
		}else if(filterType.equals("history"))
		{
			//filter for history record
		}else if(filterType.equals("users"))
		{
			//filter for users
		}else if(filterType.equals("connectionName"))
		{
			//filter for connections
		}else {
			result.setType(PhaseDictionary.FAILURE);
		}
		return result;
		
	}
	
	@RequestMapping(value="getUsers")
	public Quote getUserList()
	{
		Quote result = new Quote();
		List<User> users = userService.getUserList();
		result.setType(PhaseDictionary.SUCCESS);
		result.setValue(new ListValue<>(users));
		return result;
	}
	
	@RequestMapping(value="user/{userIdStr}")
	public Quote getUserById(@PathVariable String userIdStr)
	{
		int userId = Integer.parseInt(userIdStr);
		User user = new User();
		user.setUserId(userId);
		user = userService.selectUserById(user);

		Quote result = new Quote();
		result.setType(PhaseDictionary.SUCCESS);
		result.setValue(new UserValue(user));
		return result;
	}
	
	@RequestMapping(value="connections")
	public Quote getConnectionsList()
	{
		Quote result = new Quote();
		List<Connection> connections = connService.getConnectionList();
		result.setType(PhaseDictionary.SUCCESS);
		result.setValue(new ListValue<>(connections));
		return result;
	}
	
	
}
