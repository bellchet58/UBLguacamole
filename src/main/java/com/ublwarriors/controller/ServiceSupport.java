package com.ublwarriors.controller;

import com.ublwarriors.service.ConnectionGroupService;
import com.ublwarriors.service.ConnectionHistoryService;
import com.ublwarriors.service.ConnectionParamsService;
import com.ublwarriors.service.ConnectionService;
import com.ublwarriors.service.UserService;

public class ServiceSupport {
	public ConnectionParamsService connParamService;
	public UserService userService;
	public ConnectionService connService;
	public ConnectionGroupService connGroupService;
	public ConnectionHistoryService historyService;
}
