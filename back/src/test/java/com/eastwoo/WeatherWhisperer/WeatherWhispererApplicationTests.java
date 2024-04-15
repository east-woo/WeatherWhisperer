package com.eastwoo.WeatherWhisperer;

import com.eastwoo.WeatherWhisperer.crawler.model.WeatherRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootTest
@ActiveProfiles("test") // Ensure test profile is active if needed
public class WeatherWhispererApplicationTests {

	@Autowired
	private WebClient.Builder webClientBuilder;

	@Value("${api-key.datagokr-api-key}")
	private String datagokrApiKey;

	@Value("${weather-api.endpoints.getVilageFcst.url}")
	private String vilageFcstUrl;

	@Test
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

		WebClient webClient = webClientBuilder.baseUrl("https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0").build();

		webClient.post()
				.uri("/getVilageFcst")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Mono.just(request), WeatherRequest.class)
				.retrieve()
				.bodyToMono(String.class)
				.doOnNext(responseBody -> {
					System.out.println("Received Response Body:");
					System.out.println(responseBody);
				})
				.block(); // Block until the response is received (for testing purposes)
	}
}
