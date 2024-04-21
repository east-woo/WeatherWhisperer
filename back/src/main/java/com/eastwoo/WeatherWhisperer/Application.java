package com.eastwoo.WeatherWhisperer;

import com.eastwoo.WeatherWhisperer.crawler.model.WeatherRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private WebClient.Builder webClientBuilder;

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


        WeatherRequest request = WeatherRequest.builder(datagokrApiKey)
                .baseDate(base_date)
                .baseTime(base_time)
                .nx(Integer.valueOf(nx))
                .ny(Integer.valueOf(ny))
                .build();

        WebClient webClient = webClientBuilder.baseUrl("https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0").build();

        String response1 = webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/getVilageFcst")
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

        System.out.println(response1);
 // https://yamea-guide.tistory.com/entry/NODENEST-SERVICEKEYISNOTREGISTEREDERROR-%ED%95%B4%EA%B2%B0
    }

}