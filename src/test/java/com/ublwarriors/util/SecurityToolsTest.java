package com.ublwarriors.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ublwarriors.UbLguacamoleApplication;
import com.ublwarriors.guacamole.model.User;
import com.ublwarriors.guacamole.model.UserWithBLOBs;
import com.ublwarriors.service.UserService;
@RunWith( SpringJUnit4ClassRunner.class )
@SpringApplicationConfiguration(UbLguacamoleApplication.class)
public class SecurityToolsTest {

	@Autowired
	private UserService userService;
	
	
	@Test
	public void testAdd() throws Exception
	{
		String name = "bellchet58";
		String password = "tz8888";
		UserWithBLOBs user = new UserWithBLOBs();
		user.setUsername(name);
		user.setPasswordSalt(SecurityTools.getSalt());
		user.setPasswordHash(SecurityTools.hash(password, user.getPasswordSalt()));
		assertTrue(SecurityTools.check(password, user.getPasswordHash(), user.getPasswordSalt()));
	}

	
	@Test
	public void testHash() throws Exception
	{
		String password = "tz8888";
		String name = "bellchet58";
		UserWithBLOBs user = new UserWithBLOBs();
		user.setUsername(name);
		user = userService.selectUserByName(user);
		System.out.println(user.getPasswordHash());
		System.out.println(SecurityTools.hash(password, user.getPasswordSalt()));
		assertTrue(SecurityTools.check(password, user.getPasswordHash(), user.getPasswordSalt()));
	}

}
