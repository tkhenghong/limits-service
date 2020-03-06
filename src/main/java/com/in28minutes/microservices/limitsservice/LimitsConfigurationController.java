package com.in28minutes.microservices.limitsservice;

import com.in28minutes.microservices.limitsservice.bean.LimitsConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableHystrix
@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    // http://localhost:8080/limits
    @GetMapping("/limits")
    public LimitsConfiguration retreiveLimistFromConfigurations() {
        return new LimitsConfiguration(configuration.getMaximum(), configuration.getMinimum());
    }

    // http://localhost:8080/fault-tolerance-example
    @GetMapping("/fault-tolerance-example")
    @HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
    public LimitsConfiguration retrieveConfiguration() {
        throw new RuntimeException("Not available");
    }

    public LimitsConfiguration fallbackRetrieveConfiguration() {
        return new LimitsConfiguration(999, 9);
    }

}
