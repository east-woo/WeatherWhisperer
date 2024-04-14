package com.eastwoo.WeatherWhisperer.api.weather.model;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Please explain the class!!
 *
 * @author : dongwoo
 * @fileName : WeatherDeserializer
 * @since : 2024-03-28
 */
@RequiredArgsConstructor
public class WeatherDeserializer extends JsonDeserializer<WeatherResult.items> {

    private final ObjectMapper objectMapper;

    @Override
    public WeatherResult.items deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {

        JsonNode node = p.getCodec().readTree(p);
        JsonNode responseNode = node.findValue("response");

        JsonNode itemNode = responseNode.get("body").get("items").get("item");
        List<WeatherResult.item> items = Arrays.stream(objectMapper.treeToValue(itemNode, WeatherResult.item[].class)).collect(Collectors.toList());

        //TMX(최고온도), TMN(최저온도), REH(시간별 습도)
        List<WeatherResult.item> list = new ArrayList<>();
        for(WeatherResult.item item : items){
            if(item.getCategory().equals("TMX"))
                list.add(item);
            if(item.getCategory().equals("TMN"))
                list.add(item);
            if(item.getCategory().equals("REH")) {
                list.add(item);
            }
        }
        return new WeatherResult.items(list);
    }
}