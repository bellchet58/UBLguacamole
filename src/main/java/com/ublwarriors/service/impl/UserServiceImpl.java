package com.ublwarriors.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ublwarriors.dao.ActiveSession;
import com.ublwarriors.guacamole.dao.UserMapper;
import com.ublwarriors.guacamole.model.User;
import com.ublwarriors.guacamole.model.UserExample;
import com.ublwarriors.guacamole.model.UserWithBLOBs;
import com.ublwarriors.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public boolean isExisted(String name) {
		UserExample exam = new UserExample();
		exam.createCriteria().andUsernameEqualTo(name);
		int count = userMapper.countByExample(exam);
		return count>0?true:false;
	}

	@Override
	public UserWithBLOBs addUser(UserWithBLOBs user) {
		int affectedRows = userMapper.insertSelective(user);
		return selectUserByName(user);
	}

	@Override
	public UserWithBLOBs selectUserByName(User user) {
		if(user.getUsername() != null)
		{
			UserExample exam = new UserExample();
			exam.createCriteria().andUsernameEqualTo(user.getUsername());
			List<UserWithBLOBs> users = userMapper.selectByExampleWithBLOBs(exam);
			return users.get(0);
		}
		return null;
	}

	@Override
	public User selectUserById(User user) {
		UserWithBLOBs result = userMapper.selectByPrimaryKey(user.getUserId());
		return result;
	}

	@Override
	public List<ActiveSession> usernameFilter(String param) {
		
		return null;
	}

	@Override
	public List<User> getUserList() {
		UserExample exam = new UserExample();
		List<User> users = userMapper.selectByExample(exam);
		return users;
	}

}
