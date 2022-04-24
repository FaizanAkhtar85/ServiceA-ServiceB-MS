package com.example.demo;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	/*
	 * 
	 * used for custom redirecting api call from api gateway if some pattern matches
	 */
	@Bean
	public RouteLocator getWayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p->p.path("/get")
						.filters(f->f.addRequestHeader("MyHeader", "MyURI")
								.addRequestParameter("param", "MYValue"))
						.uri("http://httpbin:80"))
				.route(p->p.path("/service-B/*")
						.uri("lb://service-B"))
				.route(p->p.path("/service-A/**") // if path is look like that then redirect that call to following uri which shown blow
						.uri("lb://service-A"))// take service registor on eureka server
				.route(p->p.path("/service-new/**")
						.filters(f->f.rewritePath(	// change in the uri and map it 
								"/service-new/(?<segment>.*)",
								"/service-A/${segment}"))
						.uri("lb://service-A"))
				.build();
	}

}
