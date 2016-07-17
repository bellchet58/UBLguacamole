package com.ublwarriors.message;

public abstract class Permission extends Value {
	protected Integer targetId;
	protected String permission;
	public Integer getTargetId() {
		return targetId;
	}
	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
}
