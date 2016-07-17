package com.ublwarriors.message;

import java.util.List;

import com.ublwarriors.dao.ConnectionHistoryDao;
import com.ublwarriors.guacamole.model.Connection;
import com.ublwarriors.guacamole.model.ConnectionParameter;

public class ConnectionValue extends EntryValue{
	private Connection conn;
	private List<ConnectionParameter> params;
	public List<ConnectionHistoryDao> getHistory() {
		return history;
	}

	public void setHistory(List<ConnectionHistoryDao> history) {
		this.history = history;
	}

	private List<ConnectionHistoryDao> history;

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public ConnectionValue() {
	}
	
	public ConnectionValue(Connection conn)
	{
		this.conn = conn;
	}

	public List<ConnectionParameter> getParams() {
		return params;
	}

	public void setParams(List<ConnectionParameter> params) {
		this.params = params;
	}
	
}
