package com.ublwarriors.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ublwarriors.guacamole.model.Connection;
import com.ublwarriors.message.ListValue;
import com.ublwarriors.message.MessageValue;
import com.ublwarriors.message.Quote;
import com.ublwarriors.util.PhaseDictionary;

@RestController
@RequestMapping
public class PanelController extends ServiceSupport{
	
	@RequestMapping(value="/user/connectionsList")
	public Quote getConnectionList()
	{
		Quote result = new Quote();
		List<Connection> list = connService.getConnectionList();
		result.setType(PhaseDictionary.SUCCESS);
		result.setValue(new ListValue<Connection>(list));
		return result;
	}
	
	@RequestMapping(value="/user/recentConnections")
	public Quote getRecentConnections()
	{
		Quote result = new Quote();
		List<Connection> list = connService.getRecentConnections();
		result.setType(PhaseDictionary.SUCCESS);
		if(list.size() == 0)
		{
			result.setValue(new MessageValue(PhaseDictionary.MESSAGE_NORECENT));
		}else {
			result.setValue(new ListValue<Connection>(list));
		}
		return result;
	}
	
}
