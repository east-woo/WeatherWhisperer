package com.eastwoo.WeatherWhisperer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


//
//@SpringBootApplication
@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
//@EnableWebSecurity
public class WeatherWhispererApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherWhispererApplication.class, args);
	}

}
