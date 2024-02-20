package com.eastwoo.WeatherWhisperer.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Please explain the class!!
 *
 * @author : dongwoo
 * @fileName : HelloController
 * @since : 2024-01-23
 */
@RestController
public class HelloController {

    @GetMapping("/api/test")
    public String hello() {
        return "테스트입니다.";
    }
}
