package com.ublwarriors.dao;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class ActiveSession {
	private Integer connectionId;
	public Integer getConnectionId() {
		return connectionId;
	}
	public void setConnectionId(Integer connectionId) {
		this.connectionId = connectionId;
	}
	private String username;
	private Date startDate;
	private String remoteHost;
	private String connectionName;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getRemoteHost() {
		return remoteHost;
	}
	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}
	public String getConnectionName() {
		return connectionName;
	}
	public void setConnectionName(String connectionName) {
		this.connectionName = connectionName;
	}
	@Override
	public String toString() {
		return "ActiveSession [connectionId=" + connectionId + ", username=" + username + ", startDate=" + startDate
				+ ", remoteHost=" + remoteHost + ", connectionName=" + connectionName + "]";
	}
	
}
