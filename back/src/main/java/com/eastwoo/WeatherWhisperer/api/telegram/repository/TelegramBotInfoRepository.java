package com.eastwoo.WeatherWhisperer.api.telegram.repository;

import com.eastwoo.WeatherWhisperer.api.telegram.model.TelegramBotInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Please explain the class!!
 *
 * @author : dongwoo
 * @fileName : TelegramBotInfoRepository
 * @since : 2024-02-05
 */
public interface TelegramBotInfoRepository extends JpaRepository<TelegramBotInfo, String> {
    // Additional query methods can be added here if needed
}
