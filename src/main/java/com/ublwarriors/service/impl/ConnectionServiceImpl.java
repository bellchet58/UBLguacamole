package com.ublwarriors.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ublwarriors.dao.ActiveSession;
import com.ublwarriors.dao.ConnectionHistoryDao;
import com.ublwarriors.guacamole.dao.ConnectionHistoryMapper;
import com.ublwarriors.guacamole.dao.ConnectionMapper;
import com.ublwarriors.guacamole.dao.ConnectionParameterMapper;
import com.ublwarriors.guacamole.model.Connection;
import com.ublwarriors.guacamole.model.ConnectionExample;
import com.ublwarriors.guacamole.model.ConnectionHistory;
import com.ublwarriors.guacamole.model.ConnectionHistoryExample;
import com.ublwarriors.guacamole.model.ConnectionParameter;
import com.ublwarriors.guacamole.model.ConnectionParameterExample;
import com.ublwarriors.guacamole.model.User;
import com.ublwarriors.service.ConnectionHistoryService;
import com.ublwarriors.service.ConnectionService;
import com.ublwarriors.service.UserService;
@Service
public class ConnectionServiceImpl implements ConnectionService {

	
	@Autowired
	private ConnectionMapper mapper;
	
	@Autowired
	private ConnectionParameterMapper connParamMapper;
	
	@Autowired
	private ConnectionHistoryMapper historyMapper;
	
	@Autowired
	private UserService userService;
	
	@Override
	public List<Connection> getConnectionList() {
		List<Connection> list = mapper.selectByExample(new ConnectionExample());
		return list;
	}

	@Override
	public List<Connection> getRecentConnections() {
		ConnectionExample exam = new ConnectionExample();
		exam.setOrderByClause("connection_id desc");
		List<Connection> list = mapper.selectByExample(exam).subList(0, 10);
		return list;
	}

	@Override
	public List<ActiveSession> hostnameFilter(String param) {
		
		return null;
	}

	@Override
	public List<ActiveSession> connectionNameFilter(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection addConnection(Connection conn) {
		mapper.insertSelective(conn);
		ConnectionExample exam = new ConnectionExample();
		exam.setOrderByClause("connection_id desc");
		return mapper.selectByExample(exam).get(0);
	}

	@Override
	public Connection selectConnectionById(int connectionId) {
		Connection conn = mapper.selectByPrimaryKey(connectionId);
		
		return conn;
	}

	@Override
	public List<ConnectionParameter> getConnectionParamsById(int connectionId) {
		ConnectionParameterExample exam = new ConnectionParameterExample();
		exam.createCriteria().andConnectionIdEqualTo(connectionId);
		List<ConnectionParameter> params = connParamMapper.selectByExample(exam);
		return params;
	}

	@Override
	public List<ConnectionHistoryDao> getConnectionHistoryById(int connectionId) {
		ConnectionHistoryDao history = new ConnectionHistoryDao();
		ConnectionHistoryExample exam = new ConnectionHistoryExample();
		exam.createCriteria().andConnectionIdEqualTo(connectionId);
		List<ConnectionHistory> list = historyMapper.selectByExample(exam);
		for(ConnectionHistory h:list)
		{
			ConnectionExample ex = new ConnectionExample();
			ex.createCriteria().andConnectionIdEqualTo(h.getConnectionId());
			history.setConnectionName(mapper.selectByExample(ex).get(0).getConnectionName());
			history.setStartDate(h.getStartDate());
			
			User user = new User();
			user.setUserId(h.getUserId());
			history.setUsername(userService.selectUserById(user).getUsername());
			history.setDuration(getDuration(h.getStartDate(), h.getEndDate()));
		}
		return null;
	}
	
	private String getDuration(Date from, Date to)
	{
		long duration = to.getTime() - from.getTime();
		Date date = new Date(duration);
		String result = "";
		if(date.getYear()!=0)
		{
			result = date.getYear() + "Year";
		}else if(date.getMonth()!=0)
		{
			result = date.getMonth() + "Mouth";
		}else if(date.getDay() !=0)
		{
			result = date.getDay() + "Day";
		}else if(date.getHours() != 0)
		{
			result = date.getHours() + "Hours";
		}else if(date.getMinutes() != 0)
		{
			result = date.getMinutes() + "Minutes";
		}else {
			result = date.getSeconds() + "Seconds";
		}
		return result;
	}

	@Override
	public Connection getConnectionById(Integer connectionId) {
		Connection conn = mapper.selectByPrimaryKey(connectionId);
		return conn;
	}
}
