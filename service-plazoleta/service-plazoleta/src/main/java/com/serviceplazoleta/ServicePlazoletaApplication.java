package com.serviceplazoleta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
public class ServicePlazoletaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicePlazoletaApplication.class, args);
	}

}
