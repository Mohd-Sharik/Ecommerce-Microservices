package com.ecom.serverConf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ServerConfApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerConfApplication.class, args);
	}

}
