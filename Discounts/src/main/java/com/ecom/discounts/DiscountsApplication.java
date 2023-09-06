package com.ecom.discounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DiscountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscountsApplication.class, args);
	}

}
