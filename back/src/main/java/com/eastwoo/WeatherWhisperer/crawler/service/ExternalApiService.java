package com.eastwoo.WeatherWhisperer.crawler.service;

import com.eastwoo.WeatherWhisperer.crawler.model.WeatherRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ExternalApiService {

    private final WebClient.Builder webClientBuilder;

    @Value("${api-key.datagokr-api-key}")
    private String datagokrApiKey;

    /*초단기 예보 URL*/
    @Value("${weather-api.endpoints.getUltraSrtFcst.url}")
    private String ultraSrtFcstUrl;

    /*단기 예보 URL*/
    @Value("${weather-api.endpoints.getVilageFcst.url}")
    private String vilageFcstUrl;



    public ExternalApiService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }


    public void requestExternalApi() {

        String date = "20240414";
        String time = "0200";
        int nx = 55;
        int ny = 127;

        WeatherRequest request = WeatherRequest.builder(datagokrApiKey)
                .baseDate(date)
                .baseTime(time)
                .nx(nx)
                .ny(ny)
                .build();

        WebClient webClient = webClientBuilder.baseUrl(vilageFcstUrl).build();

        webClient.post()
                .uri("/")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(request), WeatherRequest.class)
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(requestBody ->{
                    System.out.println(requestBody);
                });
    }
}
