package com.eastwoo.WeatherWhisperer.crawler.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
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
@ToString
public class WeatherRequest {

    private final String serviceKey;
    // 페이지 번호
    private final int pageNo;
    //한 페이지 결과 수
    private final int numOfRows;
    // 응답 자료 형식
    private final String dataType;
    //발표 일자
    private final String baseDate;
    //발표 시각
    private final String baseTime;
    // 예보지점 X 좌표
    private final int nx;
    // 예보지점 y 좌표
    private final int ny;

    // Private constructor to enforce builder pattern
    private WeatherRequest(String serviceKey, int pageNo, int numOfRows, String dataType,
                           String baseDate, String baseTime, int nx, int ny) {
        this.serviceKey = serviceKey;
        this.pageNo = pageNo;
        this.numOfRows = numOfRows;
        this.dataType = dataType;
        this.baseDate = baseDate;
        this.baseTime = baseTime;
        this.nx = nx;
        this.ny = ny;
    }

    // Static builder method to create instances
    public static WeatherRequestBuilder builder(String serviceKey) {
        return new WeatherRequestBuilder().serviceKey(serviceKey);
    }

    // Builder class for fluent object construction
    public static class WeatherRequestBuilder {

        private String serviceKey;
        private int pageNo = 1;
        private int numOfRows = 10000;
        private String dataType = "JSON";
        private String baseDate;
        private String baseTime;
        private int nx;
        private int ny;

        private WeatherRequestBuilder() {}

        public WeatherRequestBuilder serviceKey(String serviceKey) {
            this.serviceKey = serviceKey;
            return this;
        }

        public WeatherRequestBuilder baseDate(String baseDate) {
            this.baseDate = baseDate;
            return this;
        }

        public WeatherRequestBuilder baseTime(String baseTime) {
            this.baseTime = baseTime;
            return this;
        }

        public WeatherRequestBuilder nx(int nx) {
            this.nx = nx;
            return this;
        }

        public WeatherRequestBuilder ny(int ny) {
            this.ny = ny;
            return this;
        }

        public WeatherRequest build() {
            return new WeatherRequest(serviceKey, pageNo, numOfRows, dataType,
                    baseDate, baseTime, nx, ny);
        }
    }
}