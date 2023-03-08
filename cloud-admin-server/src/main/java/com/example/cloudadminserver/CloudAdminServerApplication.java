package com.example.cloudadminserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableAdminServer
@SpringBootApplication
public class CloudAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudAdminServerApplication.class, args);
	}

}
