package com.eastwoo.WeatherWhisperer.api.telegram.service;

import com.eastwoo.WeatherWhisperer.api.telegram.model.TelegramBotInfo;
import com.eastwoo.WeatherWhisperer.api.telegram.repository.TelegramBotInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Please explain the class!!
 *
 * @author : dongwoo
 * @fileName : TelegramBotInfoService
 * @since : 2024-02-05
 */
@Service
public class TelegramBotInfoService {
    @Autowired
    private TelegramBotInfoRepository repository;

    public TelegramBotInfo saveTelegramBotInfo(TelegramBotInfo botInfo) {
        return repository.save(botInfo);
    }

    // Other service methods as needed
}
