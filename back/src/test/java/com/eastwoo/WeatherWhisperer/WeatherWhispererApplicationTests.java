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
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

@SpringBootTest

public class WeatherWhispererApplicationTests {

	@Autowired
	private WebClient.Builder webClientBuilder;

	@Value("${api-key.datagokr-api-key}")
	private String datagokrApiKey;

	@Value("${weather-api.endpoints.getVilageFcst.url}")
	private String vilageFcstUrl;

	@Test
	public void requestExternalApi() {
		String date = "20240419";
		String time = "0500";
		int nx = 55;
		int ny = 127;

		WeatherRequest request = WeatherRequest.builder(datagokrApiKey)
				.baseDate(date)
				.baseTime(time)
				.nx(nx)
				.ny(ny)
				.build();

		System.out.println(request.toString());

		// Create a DefaultUriBuilderFactory with encoding mode
		DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory();
		factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE); // Set encoding mode to NONE or VALUES_ONLY

		WebClient webClient = WebClient.builder()
				.uriBuilderFactory(factory) // Set the custom UriBuilderFactory
				.baseUrl("https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0")
				.build();

//		WebClient webClient = webClientBuilder.baseUrl("https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0").build();
		String path = "/getVilageFcst";
		webClient.get()
				.uri(uriBuilder ->
						uriBuilder.path(path)
						.queryParam("serviceKey", request.getServiceKey())
						.queryParam("dataType", request.getDataType())
						.queryParam("base_date", request.getBaseDate())
						.queryParam("base_time", request.getBaseTime())
						.queryParam("nx", request.getNx())
						.queryParam("ny", request.getNy())
						.queryParam("dataType", request.getDataType())
						.queryParam("pageNo", request.getPageNo())
						.queryParam("numOfRows", request.getNumOfRows())
						.build())
				.retrieve()
				.bodyToMono(String.class)
				.doOnNext(responseBody -> {
					System.out.println("Received Response Body:");
					System.out.println(responseBody);
				})
				.block();
	}
}
