package com.eastwoo.WeatherWhisperer.api.weather.repository;

import com.eastwoo.WeatherWhisperer.api.weather.entity.WeatherArea;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Please explain the class!!
 *
 * @author : dongwoo
 * @fileName : AreaRepository
 * @since : 2024-03-28
 */
public interface AreaRepository extends JpaRepository<WeatherArea, String> {
}
