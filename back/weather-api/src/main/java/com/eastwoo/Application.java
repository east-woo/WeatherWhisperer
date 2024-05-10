package com.eastwoo;

import com.eastwoo.WeatherWhisperer.crawler.model.WeatherRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Value("${api-key.datagokr-api-key}")
    private String datagokrApiKey;

    @Value("${weather-api.endpoints.getVilageFcst.url}")
    private String vilageFcstUrl;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run( String... args ) throws Exception {
        String base_date = "20240421";
        String base_time = "0500";
        String nx = "55";
        String ny = "127";

        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(vilageFcstUrl);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY);

        WebClient webClient = WebClient.builder().uriBuilderFactory(factory).baseUrl(vilageFcstUrl).build();

        WeatherRequest request = WeatherRequest.builder(datagokrApiKey)
                .baseDate(base_date)
                .baseTime(base_time)
                .nx(Integer.valueOf(nx))
                .ny(Integer.valueOf(ny))
                .build();

        String response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("serviceKey", request.getServiceKey())
                        .queryParam("base_date", request.getBaseDate())
                        .queryParam("base_time", request.getBaseTime())
                        .queryParam("nx", request.getNx())
                        .queryParam("ny", request.getNy())
                        .queryParam("dataType", request.getDataType())
                        .queryParam("pageNo", request.getPageNo())
                        .queryParam("numOfRows", request.getNumOfRows())
                        .build())
                .retrieve().bodyToMono(String.class).block();

        System.out.println(response);
    }

}