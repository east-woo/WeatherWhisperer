package com.eastwoo.WeatherWhisperer.crawler.service;

import com.eastwoo.WeatherWhisperer.crawler.model.WeatherRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import reactor.core.publisher.Mono;


public interface ExternalApiService {
    /*초단기 실황 조회*/
    public void getUltraSrtNcst();

    /*초단기 예보 조회*/
    public void getUltraSrtFcst();

    /*단기 예보 조회*/
    public void getVilageFcst();

    /*예보 버전 조회*/
    public void getFcstVersion();
}
