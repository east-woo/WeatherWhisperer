package com.eastwoo.WeatherWhisperer.api.telegram.repository;

import com.eastwoo.WeatherWhisperer.api.telegram.model.TelegramBotInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * Please explain the class!!
 *
 * @author : dongwoo
 * @fileName : TelegramBotInfoRepository
 * @since : 2024-02-05
 */
public interface TelegramBotInfoRepository extends JpaRepository<TelegramBotInfo, String>, QuerydslPredicateExecutor<TelegramBotInfo> {
    // Additional query methods can be added here if needed
}
