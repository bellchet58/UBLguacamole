package com.ublwarriors.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ublwarriors.guacamole.model.ConnectionGroup;
@JsonIgnoreProperties(ignoreUnknown = true)
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

	@Override
	public String toString() {
		return "ConnectionGroupValue [group=" + group + ", name=" + name + ", Id=" + Id + "]";
	}

	
}
