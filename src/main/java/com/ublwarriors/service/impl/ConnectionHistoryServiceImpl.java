package com.ublwarriors.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ublwarriors.dao.ActiveSession;
import com.ublwarriors.guacamole.dao.ConnectionHistoryMapper;
import com.ublwarriors.guacamole.dao.ConnectionMapper;
import com.ublwarriors.guacamole.dao.UserMapper;
import com.ublwarriors.guacamole.model.ConnectionHistory;
import com.ublwarriors.guacamole.model.ConnectionHistoryExample;
import com.ublwarriors.service.ConnectionHistoryService;
import com.ublwarriors.service.ConnectionParamsService;
import com.ublwarriors.service.ConnectionService;
import com.ublwarriors.service.UserService;
import com.ublwarriors.util.PhaseDictionary;
@Service
public class ConnectionHistoryServiceImpl implements ConnectionHistoryService {

	@Autowired
	private ConnectionHistoryMapper connHistoryMapper;
	
	@Autowired
	private ConnectionMapper connMapper;
	
	@Autowired
	private ConnectionParamsService connParamService;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<ActiveSession> getActiveSessionsList() {
		ActiveSession session = new ActiveSession();
		ConnectionHistoryExample exam = new ConnectionHistoryExample();
		List<ConnectionHistory> records = connHistoryMapper.selectByExample(exam);
		List<ActiveSession> list = new ArrayList<>();
		for(ConnectionHistory record:records)
		{
			session.setConnectionId(record.getConnectionId());
			session.setConnectionName(connMapper.selectByPrimaryKey(session.getConnectionId()).getConnectionName());
			session.setRemoteHost(connParamService.getParamsById(session.getConnectionId()).get(PhaseDictionary.HOSTNAME));
			session.setStartDate(record.getStartDate());
			session.setUsername(userMapper.selectByPrimaryKey(record.getUserId()).getUsername());
			list.add(session);
		}
		return list;
	}

	@Override
	public List<ActiveSession> startDateFilter(String param) {
		return null;
	}

}
