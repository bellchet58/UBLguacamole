package com.ublwarriors.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ublwarriors.guacamole.model.ConnectionGroup;
import com.ublwarriors.message.ConnectionGroupValue;
import com.ublwarriors.message.Quote;
import com.ublwarriors.service.ConnectionGroupService;
import com.ublwarriors.util.PhaseDictionary;

import ch.qos.logback.access.pattern.RequestMethodConverter;

@RestController
@RequestMapping(value="connectionGroup")
public class ConnectionGroupController extends ServiceSupport{
	@RequestMapping(value="addConnectionGroup", method=RequestMethod.POST)
	public Quote addConnectionGroup(@RequestParam ConnectionGroup group)
	{
		Quote result = new Quote();
		ConnectionGroup resultGroup = connGroupService.addConnectionGroup(group);
		result.setType(PhaseDictionary.SUCCESS);
		result.setValue(new ConnectionGroupValue(resultGroup));
		return result;
	}
	
	@RequestMapping(value="editConnectionGroup", method=RequestMethod.POST)
	public Quote editConnectionGroup(@RequestParam ConnectionGroup group)
	{
		Quote result = new Quote();
		ConnectionGroup resultGroup = connGroupService.editConnectionGroup(group);
		result.setType(PhaseDictionary.SUCCESS);
		result.setValue(new ConnectionGroupValue(resultGroup));
		return result;
	}
	
	@RequestMapping(value="deleteConnectionGroup", method=RequestMethod.POST)
	public Quote deleteConnectionGroup(@RequestParam ConnectionGroup group)
	{
		Quote result = new Quote();
		ConnectionGroup resultGroup = connGroupService.deleteConnectionGroup(group);
		result.setType(PhaseDictionary.SUCCESS);
		result.setValue(new ConnectionGroupValue(resultGroup));
		return result;
	}
}
