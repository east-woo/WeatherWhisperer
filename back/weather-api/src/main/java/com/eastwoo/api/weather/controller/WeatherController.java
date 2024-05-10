package com.eastwoo.api.weather.controller;

import com.eastwoo.WeatherWhisperer.api.weather.model.WeatherResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Please explain the class!!
 *
 * @author : dongwoo
 * @fileName : WeatherController
 * @since : 2024-03-28
 */
@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    /*날씨 조회하는 API ()*/
    @GetMapping("/getVilageFcst")
    public void getVilageFcst() {

        ObjectMapper objectMapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> entity = new HttpEntity<>(new HttpHeaders());

        WeatherResult.items response = null;

        String url = "https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst?serviceKey={서비스키}&pageNo=1&numOfRows=1000&dataType=json&base_date=20240328&base_time=0500&nx=55&ny=127";

        try{
            ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            System.out.println(result);
            response = objectMapper.readValue(result.getBody(), WeatherResult.items.class);
            System.out.println(response);
        } catch (IOException e){
            System.out.println("A");
        }

        System.out.println(ToStringBuilder.reflectionToString(response));
    }

}
