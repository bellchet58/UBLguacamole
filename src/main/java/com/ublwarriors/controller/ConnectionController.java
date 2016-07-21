package com.ublwarriors.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ublwarriors.dao.ConnectionHistoryDao;
import com.ublwarriors.guacamole.model.Connection;
import com.ublwarriors.guacamole.model.ConnectionHistory;
import com.ublwarriors.guacamole.model.ConnectionParameter;
import com.ublwarriors.message.ConnectionValue;
import com.ublwarriors.message.FailureValue;
import com.ublwarriors.message.ListValue;
import com.ublwarriors.message.Quote;
import com.ublwarriors.util.PhaseDictionary;

@RestController
@RequestMapping("/connection")
public class ConnectionController extends ServiceSupport{
	Logger logger = LoggerFactory.getLogger(ConnectionController.class);
	
	@RequestMapping(value="/addConnection",method=RequestMethod.POST)
	public Quote addConnection(@RequestParam(value="connectionName") String connectionName,
			@RequestParam(value="maxConnections",required=false) String maxConnections,
			@RequestParam(value="maxConnectionsPerUser",required=false) String maxConnectionsPerUser,
			@RequestParam(value="protocol") String protocol)
	{
		Quote result = new Quote();	
		Connection conn = new Connection();
		conn.setConnectionName(connectionName);
		logger.error("{},{}",maxConnections,maxConnectionsPerUser);
		if(!maxConnections.equals(""))
		{
			conn.setMaxConnections(Integer.parseInt(maxConnections));
		}
		if(!maxConnectionsPerUser.equals(""))
		{
			conn.setMaxConnectionsPerUser(Integer.parseInt(maxConnectionsPerUser));
		}
		conn.setProtocol(protocol);
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
	
	@RequestMapping(value="addConnectionParam",method=RequestMethod.POST)
	public Quote addConnectionParam(@RequestParam(value="connectionId") Integer connectionId,
			@RequestParam(value="hostname") String hostname,
			@RequestParam(value="port") String port,
			@RequestParam(value="password",required=false) String password,
			@RequestParam(value="readonly",required=false) boolean readOnly,
			@RequestParam(value="swapRedBlueComponent",required=false) boolean swapRedBlueComponent,
			@RequestParam(value="inputCursor",required=false) String inputCursor,
			@RequestParam(value="inputColorDepth",required=false) String inputColorDepth)
	{
		
		List<ConnectionParameter> params = new ArrayList<>();
		HashMap<String, String> map = new HashMap<>();
		
		map.put(PhaseDictionary.HOSTNAME, hostname);
		map.put(PhaseDictionary.PORT, port);
		if(!password.equals(""))
		{
			map.put(PhaseDictionary.PASSWORD, password);
		}
		map.put("readonly", ""+readOnly);
		map.put("swapRedBlueComponent", ""+swapRedBlueComponent);
		map.put("inputCursor", inputCursor);
		map.put("inputColorDepth", inputColorDepth);
		
		for(String name:map.keySet())
		{
			ConnectionParameter param = new ConnectionParameter();
			param.setConnectionId(connectionId);
			param.setParameterName(name);
			param.setParameterValue(map.get(name));
			logger.error("{}:{}",param.getParameterName(),param.getParameterValue());
			params.add(param);
		}
		for(ConnectionParameter p:params)
		{
			logger.error("{}:{}",p.getParameterName(),p.getParameterValue());
		}
		List<ConnectionParameter> resultList = connParamService.addParameters(params);
		Quote result = new Quote();
		result.setType(PhaseDictionary.SUCCESS);
		result.setValue(new ListValue<>(resultList));
		return result;
	}
}
