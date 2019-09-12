package com.principal.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class Resolver extends WebMvcConfigurerAdapter{
	 @Override
	    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	    }
	@Bean
	public InternalResourceViewResolver getResolver()
	{
		InternalResourceViewResolver res=new InternalResourceViewResolver();
		res.setPrefix("/WEB-INF/jsp/");
		res.setSuffix(".jsp");
		return res;
	}
}
