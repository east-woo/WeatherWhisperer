package com.eastwoo.WeatherWhisperer;

import com.eastwoo.WeatherWhisperer.crawler.model.WeatherRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WeatherWhispererApplicationTests {
	@Value("${api-key.datagokr-api-key}")
	private String api;

	@Value("${weather-api.endpoints.getUltraSrtNcst.url}")
	private String ultraSrtNcst;
	@Test
	void contextLoads() {
		System.out.println(ultraSrtNcst);
	}

}
