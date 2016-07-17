package com.ublwarriors.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class SecurityToolsTest {

	@Test
	public void test() {
		String password = "tz8888";
		try {
			String hash = SecurityTools.getSaltedHash(password);
			System.out.println(hash);
			assertTrue(SecurityTools.check(password, hash));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
