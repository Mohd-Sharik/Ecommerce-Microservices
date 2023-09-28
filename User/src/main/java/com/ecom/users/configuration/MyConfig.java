package com.ecom.users.configuration;

import org.springframework.context.annotation.Bean;

public class MyConfig {
	
	
	 @Bean
	    public feign.Logger.Level feignLoggerLevel() {
	        return feign.Logger.Level.FULL; // Enable Feign logging for debugging
	    }

}
