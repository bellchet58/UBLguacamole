package com.ublwarriors.service;

import com.ublwarriors.guacamole.model.ConnectionGroup;

public interface ConnectionGroupService {
	public ConnectionGroup selectConnectionGroup(ConnectionGroup conn);
	public ConnectionGroup selectConnectionGroupById(int connectionGroupId);
	public ConnectionGroup editConnectionGroup(ConnectionGroup conn);
	public ConnectionGroup addConnectionGroup(ConnectionGroup group);
	public ConnectionGroup deleteConnectionGroup(ConnectionGroup group);
}
