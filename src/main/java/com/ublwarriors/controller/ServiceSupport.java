package com.ublwarriors.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.ublwarriors.service.ConnectionGroupService;
import com.ublwarriors.service.ConnectionHistoryService;
import com.ublwarriors.service.ConnectionParamsService;
import com.ublwarriors.service.ConnectionService;
import com.ublwarriors.service.UserService;

public class ServiceSupport {
	@Autowired
	public ConnectionParamsService connParamService;
	@Autowired
	public UserService userService;
	@Autowired
	public ConnectionService connService;
	@Autowired
	public ConnectionGroupService connGroupService;
	@Autowired
	public ConnectionHistoryService historyService;
}
