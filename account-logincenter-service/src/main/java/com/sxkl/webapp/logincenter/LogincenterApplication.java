package com.sxkl.webapp.logincenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class LogincenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogincenterApplication.class, args);
	}
}
