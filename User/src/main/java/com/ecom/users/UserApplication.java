package com.ecom.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
//@EnableJpaRepositories("com.onlineShop.example.*")
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

}
