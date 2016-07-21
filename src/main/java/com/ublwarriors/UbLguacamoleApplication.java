package com.ublwarriors;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.ublwarriors.guacamole.net.TutorialGuacamoleTunnelServlet;

@SpringBootApplication
public class UbLguacamoleApplication {

	Logger logger = LoggerFactory.getLogger(UbLguacamoleApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(UbLguacamoleApplication.class, args);
	}
	
	
}
