package br.com.flettieri.apicustomerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping("/api-customer-service")
public class ApiCustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCustomerServiceApplication.class, args);
	}

}
