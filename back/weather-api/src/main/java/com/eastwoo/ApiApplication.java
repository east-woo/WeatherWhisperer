package com.eastwoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * Please explain the class!!
 *
 * @author : dongwoo
 * @fileName : ApiApplication
 * @since : 2024-05-08
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ApiApplication {
    public static void main(String[] args) {
        //System.setProperty("spring.config.name", "application, application-API-KEY, application-dev");
        SpringApplication.run(ApiApplication.class, args);
    }
}
