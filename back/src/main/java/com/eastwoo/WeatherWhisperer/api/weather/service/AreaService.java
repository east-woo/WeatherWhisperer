package com.eastwoo.WeatherWhisperer.api.weather.service;

import com.eastwoo.WeatherWhisperer.api.weather.model.WeatherArea;
import com.eastwoo.WeatherWhisperer.api.weather.repository.AreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Please explain the class!!
 *
 * @author : dongwoo
 * @fileName : AreaService
 * @since : 2024-03-28
 */
@Service
@RequiredArgsConstructor
public class AreaService {
    private final AreaRepository areaRepository;

    private List<WeatherArea> getStdgCtpvNmList(){

        return areaRepository.findAll();
    }
}
