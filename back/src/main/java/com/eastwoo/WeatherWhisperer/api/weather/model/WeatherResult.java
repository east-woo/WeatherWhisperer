package com.eastwoo.WeatherWhisperer.api.weather.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Please explain the class!!
 *
 * @author : dongwoo
 * @fileName : WeatherResult
 * @since : 2024-03-28
 */
@Getter
@NoArgsConstructor
public class WeatherResult {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonDeserialize(using = WeatherDeserializer.class)
    public static class items{
        private List<item> item;
    }

    @Getter
    @NoArgsConstructor
    public static class item{
        private String baseDate;
        private String baseTime;
        private String category;
        private String fcstDate;
        private String fcstTime;
        private String fcstValue;
        private Long nx;
        private Long ny;
    }
}