package com.ublwarriors.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ublwarriors.dao.ActiveSession;
import com.ublwarriors.dao.ConnectionHistoryDao;
import com.ublwarriors.guacamole.model.Connection;
import com.ublwarriors.guacamole.model.ConnectionHistory;
import com.ublwarriors.guacamole.model.ConnectionParameter;
@Service
public interface ConnectionService {
	//based on the available privilege
	public List<Connection> getConnectionList();
	
	public List<Connection> getRecentConnections();

	public List<ActiveSession> hostnameFilter(String param);

	public List<ActiveSession> connectionNameFilter(String param);

	public Connection addConnection(Connection conn);

	public Connection selectConnectionById(int connectionId);

	public List<ConnectionParameter> getConnectionParamsById(int connectionId);

	public List<ConnectionHistoryDao> getConnectionHistoryById(int connectionId);

	public Connection getConnectionById(Integer connectionId);
}
