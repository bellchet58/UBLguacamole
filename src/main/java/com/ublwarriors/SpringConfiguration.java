package com.ublwarriors;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.util.SocketUtils;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import com.ublwarriors.guacamole.net.StandardGuacamoleTunnelServlet;

@EnableAutoConfiguration
@Configuration
public class SpringConfiguration {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Bean
	public ServletRegistrationBean servletRegistrationBean()
	{
		printStacks();
		ServletRegistrationBean bean = new ServletRegistrationBean(new StandardGuacamoleTunnelServlet(), "/tunnel");
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
	
	@Bean
	public HiddenHttpMethodFilter HiddenHttpMethodFilter()
	{
		return new HiddenHttpMethodFilter(){
	        @Override
	        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	                throws ServletException, IOException
	        {
	            if("POST".equals(request.getMethod()) && request.getRequestURI().startsWith("/tunnel")) {
	                filterChain.doFilter(request, response);
	            } else {
	                super.doFilterInternal(request, response, filterChain);
	            }
	        }
	    };
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
