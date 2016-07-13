package com.ublwarriors;

import org.apache.catalina.connector.Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.embedded.Ssl;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.SocketUtils;

import com.ublwarriors.controller.HelloServlet;
import com.ublwarriors.guacamole.net.TutorialGuacamoleTunnelServlet;

@EnableAutoConfiguration
@Configuration
public class SpringConfiguration {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Bean
	public ServletRegistrationBean servletRegistrationBean()
	{
		printStacks();
		return new ServletRegistrationBean(new TutorialGuacamoleTunnelServlet(), "/tunnel");
	}
	
	@Bean
	public Integer port() {
		return SocketUtils.findAvailableTcpPort();
	}

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
		tomcat.addAdditionalTomcatConnectors(createStandardConnector());
		return tomcat;
	}

	private Connector createStandardConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setPort(port());
		return connector;
	}
	
	@Bean
	public ServletRegistrationBean helloServletBean()
	{
		printStacks();
		return new ServletRegistrationBean(new HelloServlet(), "/helloServlet");
	}
	
	private void printStacks()
	{
		StackTraceElement[] elements = Thread.currentThread().getStackTrace();
		logger.debug("========================");
		for(StackTraceElement elem: elements)
		{
			logger.debug(elem.toString());
		}
	}
}
