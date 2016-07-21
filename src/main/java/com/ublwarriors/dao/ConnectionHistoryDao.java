package com.ublwarriors.dao;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class ConnectionHistoryDao {
	private String username;
	private Date startDate;
	private String duration;
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
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getConnectionName() {
		return connectionName;
	}
	public void setConnectionName(String connectionName) {
		this.connectionName = connectionName;
	}
	@Override
	public String toString() {
		return "ConnectionHistoryDao [username=" + username + ", startDate=" + startDate + ", duration=" + duration
				+ ", connectionName=" + connectionName + "]";
	}
	
}
