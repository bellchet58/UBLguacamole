package com.ublwarriors.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ublwarriors.guacamole.dao.ConnectionParameterMapper;
import com.ublwarriors.guacamole.model.ConnectionParameter;
import com.ublwarriors.guacamole.model.ConnectionParameterExample;
import com.ublwarriors.service.ConnectionParamsService;
import com.ublwarriors.service.ConnectionService;

@Service
public class ConnectionParamServiceImpl implements ConnectionParamsService{
	
	Logger logger = LoggerFactory.getLogger(ConnectionParamServiceImpl.class);
	
	@Autowired
	private ConnectionParameterMapper paramMapper;
	
	@Override
	public HashMap<String, String> getParamsById(Integer connId) {
		ConnectionParameterExample exam = new ConnectionParameterExample();
		exam.createCriteria().andConnectionIdEqualTo(connId);
		List<ConnectionParameter> params = paramMapper.selectByExample(exam);
		HashMap<String, String> map = new HashMap<>();
		for(ConnectionParameter param : params)
		{
			map.put(param.getParameterName(), param.getParameterValue());
		}
		return map;
	}

	@Override
	public List<ConnectionParameter> addParameters(List<ConnectionParameter> params) {
		for(ConnectionParameter param:params)
		{
			logger.debug("{}'s {}:{}",param.getConnectionId(),param.getParameterName(),param.getParameterValue());
			paramMapper.insertSelective(param);
		}
		return params;
	}
	
	
	
}
