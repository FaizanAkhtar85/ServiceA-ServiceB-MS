package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceAHomeController {
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ServiceBProxy proxy;

	@GetMapping("service-A/home")
	public String getMsg() {
		String response = proxy.retrieveServiceBResponse();
		logger.info("{}"+response);
		return response;
	}
}
