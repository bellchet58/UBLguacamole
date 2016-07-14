package com.ublwarriors.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configure extends Properties{

	private static final long serialVersionUID = 1L;
	private static Configure instance;
	private static FileInputStream in;

	private Configure() {
		String path = this.getClass().getClassLoader()
				.getResource("config.properties").getPath();
		System.out.println("读取系统配置文件,path=" + path);
		File file = new File(path);
		try {
			in = new FileInputStream(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Configure getInstance() {
		if (instance == null) {
			synchronized (Configure.class) {
				if (instance == null) {
					instance = new Configure();
					try {
						instance.load(in);
					} catch (IOException e) {
						instance = null;
						e.printStackTrace();
					}
				}
			}
		}
		return instance;
	}

}
