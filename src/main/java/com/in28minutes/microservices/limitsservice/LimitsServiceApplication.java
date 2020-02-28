package com.in28minutes.microservices.limitsservice;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
// Create a microservice
// Components needed in Spring Initializer:
// Spring 2.2.0 and above WITHOUT SNAPSHOT version
// Artifact name MUST be created correctly, because we will use that in later stages
// Dependencies needed: 
// 1. Spring Web Starter
// 2. Spring Boot DevTools
// 3. Spring Boot Actuator: To monitor APItraffic
// 4. Spring Boot Config Client: To connect to your Spring Boot Cloud Config app
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

// We have created a micro service 
@SpringBootApplication
@EnableDiscoveryClient
public class LimitsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LimitsServiceApplication.class, args);
	}

	// Trace all requests
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
