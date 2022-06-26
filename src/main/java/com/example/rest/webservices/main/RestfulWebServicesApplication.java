package com.example.rest.webservices.main;

import com.example.rest.webservices.config.SpringSecurityConfigurationBasicAuth;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan({"com.example.rest.webservices.controller", "com.example.rest.webservices.services"})
@Import(SpringSecurityConfigurationBasicAuth.class)
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

}
