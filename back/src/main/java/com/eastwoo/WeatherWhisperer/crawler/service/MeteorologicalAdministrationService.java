package com.eastwoo.WeatherWhisperer.crawler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class MeteorologicalAdministrationService {

    @Value("${api-key.datagokr-api-key}")
    private String datagokrApiKey;

    @Value("${weather-api.endpoints.getUltraSrtNcst.url}")
    private String ultraSrtNcst;

    public void api요청(){

    }
}
