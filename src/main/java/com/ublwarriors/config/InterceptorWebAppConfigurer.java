package com.ublwarriors.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ublwarriors.interceptor.UserAuthInterceptor;
@Configuration
public class InterceptorWebAppConfigurer extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new UserAuthInterceptor()).addPathPatterns("/user/*");
		super.addInterceptors(registry);
	}
	
}
