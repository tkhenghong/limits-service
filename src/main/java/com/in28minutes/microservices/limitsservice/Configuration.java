package com.in28minutes.microservices.limitsservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// Better way to read application.properties file values by Create a class

@Component
@ConfigurationProperties("limits-service") // This will make Spring Boot find anything that starts with 'limits-service in application.properties file.
public class Configuration {
    private int minimum;
    private int maximum;

    // You must create getter and setters for those properties under @ConfigurationProperties method
    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }
}
