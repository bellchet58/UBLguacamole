package com.ublwarriors.controller;

import java.util.List;

import org.springframework.social.connect.ConnectionValues;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ublwarriors.dao.ConnectionHistoryDao;
import com.ublwarriors.guacamole.model.Connection;
import com.ublwarriors.guacamole.model.ConnectionHistory;
import com.ublwarriors.guacamole.model.ConnectionParameter;
import com.ublwarriors.message.ConnectionValue;
import com.ublwarriors.message.FailureValue;
import com.ublwarriors.message.Quote;
import com.ublwarriors.util.PhaseDictionary;

@Controller
public class ConnectionController extends ServiceSupport{
//	@RequestMapping(value="/prepareConnect")
//	public String prepareConnect(@RequestParam Connection conn)
//	{
//		if(conn.getConnectionId() != null)
//		{
//			
//		}
//	}
	
	@RequestMapping(value="addConnection")
	public Quote addConnection(@RequestParam Connection conn)
	{
		Quote result = new Quote();		
		if(conn != null) {
			conn = connService.addConnection(conn);
			result.setType(PhaseDictionary.SUCCESS);
			result.setValue(new ConnectionValue(conn));
		}else{
			result.setType(PhaseDictionary.FAILURE);
			result.setValue(new FailureValue());
		}
		return result;
	}
	
	@RequestMapping(value="editConnection/{connectionIdStr}")
	public Quote editConnection(@PathVariable String connectionIdStr)
	{
		Quote result = new Quote();
		if(connectionIdStr != null)
		{
			int connectionId = Integer.parseInt(connectionIdStr);
			Connection conn = connService.selectConnectionById(connectionId);
			List<ConnectionParameter> params = connService.getConnectionParamsById(connectionId);
			List<ConnectionHistoryDao> history = connService.getConnectionHistoryById(connectionId);
			result.setType(PhaseDictionary.SUCCESS);
			ConnectionValue value  = new ConnectionValue(conn);
			value.setParams(params);
			value.setHistory(history);
			result.setValue(value);
		}else {
			result.setType(PhaseDictionary.FAILURE);
			result.setValue(new FailureValue());
		}
		return result;
	}
}
