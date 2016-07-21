package com.ublwarriors.message;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ublwarriors.guacamole.model.User;
import com.ublwarriors.guacamole.model.UserWithBLOBs;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserValue extends EntryValue {
	private byte[] passwordSalt;
	private byte[] passwordHash;
	public UserValue(UserWithBLOBs user) {
		this.Id = user.getUserId();
		this.name = user.getUsername();
		this.passwordHash = user.getPasswordHash();
		this.passwordSalt = user.getPasswordSalt();
	}
	public UserValue(User user)
	{
		this.Id = user.getUserId();
		this.name = user.getUsername();
		this.passwordHash = null;
		this.passwordSalt = null;
	}
	public byte[] getPasswordSalt() {
		return passwordSalt;
	}
	public void setPasswordSalt(byte[] passwordSalt) {
		this.passwordSalt = passwordSalt;
	}
	public byte[] getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(byte[] passwordHash) {
		this.passwordHash = passwordHash;
	}
	@Override
	public String toString() {
		return "UserValue [name=" + name + ", Id=" + Id + "]";
	}
	
	
}
