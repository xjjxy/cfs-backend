package com.hutb.cfs.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.hutb.cfs.controller"})
public class MvcConfig{
	public MvcConfig() {
		// TODO Auto-generated constructor stub
		System.out.println("MvcConfig()---");
	}
	
}
