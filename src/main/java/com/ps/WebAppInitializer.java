package com.ps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Web application.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.ps")
public class WebAppInitializer{

    /**
     * Entry point of the application
     * @param args agrs
     * @throws Exception all exceptions
     */
    public static void main(String[] args) throws Exception{
        SpringApplication.run(WebAppInitializer.class, args);
    }
}