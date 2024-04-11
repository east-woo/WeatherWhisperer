package com.eastwoo.WeatherWhisperer.api.weather.repository;

import com.eastwoo.WeatherWhisperer.api.weather.model.WeatherArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * Please explain the class!!
 *
 * @author : dongwoo
 * @fileName : AreaRepository
 * @since : 2024-03-28
 */
public interface AreaRepository extends JpaRepository<WeatherArea, String> {
}
