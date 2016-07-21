package com.ublwarriors.service.impl;

import static org.junit.Assert.*;

import org.apache.log4j.spi.LoggerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ublwarriors.UbLguacamoleApplication;
import com.ublwarriors.guacamole.model.ConnectionGroup;
import com.ublwarriors.service.ConnectionGroupService;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringApplicationConfiguration(UbLguacamoleApplication.class)
public class ConnectionGroupServiceImplTest {
	
	Logger logger = org.slf4j.LoggerFactory.getLogger(ConnectionGroupServiceImplTest.class);
	@Autowired
	ConnectionGroupService service;
//	@Test
//	public void testSelectConnectionGroup() {
//		ConnectionGroup group = new ConnectionGroup();
//		group.setConnectionGroupId(null);
//		group.setConnectionGroupName("test");
//		group = service.addConnectionGroup(group);
//		logger.debug(group.getConnectionGroupName());
//	}

}
