package com.eastwoo.api.weather.service;

import com.eastwoo.WeatherWhisperer.api.weather.entity.WeatherArea;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
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

public class AreaService extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public AreaService(JPAQueryFactory jpaQueryFactory) {
        super(WeatherArea.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }


    private List<WeatherArea> getStdgCtpvNmList(){

        return null;
    }
}
