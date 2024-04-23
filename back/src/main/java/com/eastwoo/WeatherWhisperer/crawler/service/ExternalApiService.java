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

@Service
public class ExternalApiService {

    @Value("${api-key.datagokr-api-key}")
    private String datagokrApiKey;

    /*초단기 예보 URL*/
    @Value("${weather-api.endpoints.getUltraSrtFcst.url}")
    private String ultraSrtFcstUrl;

    /*단기 예보 URL*/
    @Value("${weather-api.endpoints.getVilageFcst.url}")
    private String vilageFcstUrl;



    public void requestExternalApi() {
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
