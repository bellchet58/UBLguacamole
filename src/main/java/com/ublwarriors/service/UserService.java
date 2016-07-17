package com.ublwarriors.service;

import java.util.List;

import com.ublwarriors.dao.ActiveSession;
import com.ublwarriors.guacamole.model.User;
import com.ublwarriors.guacamole.model.UserWithBLOBs;

public interface UserService {
	public boolean isExisted(String name);
	public UserWithBLOBs addUser(UserWithBLOBs user);
	public UserWithBLOBs selectUserByName(User user);
	public User selectUserById(User user);
	public List<ActiveSession> usernameFilter(String param);
	public List<User> getUserList();
}
