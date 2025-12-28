package com.ritanath.jwtauthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;


@SpringBootApplication
public class JwtauthenticationApplication {

	public static void main(String[] args) {
		Dotenv env=Dotenv.load();
		System.setProperty("database_url", env.get("database_url"));
		System.setProperty("database_username", env.get("database_username"));
		System.setProperty("database_password", env.get("database_password"));
		SpringApplication.run(JwtauthenticationApplication.class, args);
	}

}

