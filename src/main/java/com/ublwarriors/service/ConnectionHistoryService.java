package com.ublwarriors.service;

import java.util.List;

import com.ublwarriors.dao.ActiveSession;

public interface ConnectionHistoryService {
	public List<ActiveSession> getActiveSessionsList();

	public List<ActiveSession> startDateFilter(String param);
}
