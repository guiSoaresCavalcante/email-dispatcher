package com.infnet.emaildispatcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmailDispatcherApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailDispatcherApiApplication.class, args);
	}

}
