package com.example.demo.controller;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="service-B")
@LoadBalancerClient(name="service-B")
public interface ServiceBProxy {
	@GetMapping("service-B/homeForB")
	public String retrieveServiceBResponse();
}
