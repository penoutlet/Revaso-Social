package com.revaso.revaso;

import com.revaso.revaso.models.LoginCredentials;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RevasoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RevasoApplication.class, args);
	}

	@Bean
	public LoginCredentials loginCreds(){
		return new LoginCredentials();
	}
}
