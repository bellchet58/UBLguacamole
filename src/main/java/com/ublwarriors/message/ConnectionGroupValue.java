package com.ublwarriors.message;

import com.ublwarriors.guacamole.model.ConnectionGroup;

public class ConnectionGroupValue extends EntryValue {
	private ConnectionGroup group;

	public ConnectionGroup getGroup() {
		return group;
	}

	public void setGroup(ConnectionGroup group) {
		this.group = group;
	}

	public ConnectionGroupValue(ConnectionGroup group) {
		this.group = group;
		this.name = group.getConnectionGroupName();
	}
	public ConnectionGroupValue(){
		this.name = group.getConnectionGroupName();
	}
}
