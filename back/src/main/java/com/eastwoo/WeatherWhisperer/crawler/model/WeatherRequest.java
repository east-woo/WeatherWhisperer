package com.eastwoo.WeatherWhisperer.crawler.model;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Please explain the class!!
 *
 * @author : dongwoo
 * @fileName : WeatherRequest
 * @since : 2024-03-28
 */
@Getter
public class WeatherRequest {

    public String serviceKey;
    // 페이지 번호
    public int pageNo = 1;

    //한 페이지 결과 수
    public int numOfRows = 10000;

    // 응답 자료 형식
    public String dataType = "json";

    //발표 일자
    public String baseDate;

    //발표 시각
    public String baseTime;

    // 예보지점 X 좌표
    public int nx;

    // 예보지점 y 좌표
    public int ny;
}
