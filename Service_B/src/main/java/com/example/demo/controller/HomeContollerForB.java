package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeContollerForB {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment;
	
	@GetMapping("service-B /homeForB")
	public String homeForB() {
		logger.info("{}","in service B");
		return "Response from service B "+Integer.parseInt(environment.getProperty("local.server.port"));
	}
}
