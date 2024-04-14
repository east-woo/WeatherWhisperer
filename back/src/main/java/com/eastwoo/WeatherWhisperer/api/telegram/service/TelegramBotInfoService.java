package com.eastwoo.WeatherWhisperer.api.telegram.service;

import com.eastwoo.WeatherWhisperer.api.telegram.entity.TelegramBotInfo;
import com.eastwoo.WeatherWhisperer.api.telegram.repository.TelegramBotInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Please explain the class!!
 *
 * @author : dongwoo
 * @fileName : TelegramBotInfoService
 * @since : 2024-02-05
 */
@Service
@RequiredArgsConstructor
public class TelegramBotInfoService {

    private final TelegramBotInfoRepository repository;

    public TelegramBotInfo saveTelegramBotInfo(TelegramBotInfo botInfo) {
        return repository.save(botInfo);
    }

    public List<TelegramBotInfo> getTelegramBotInfo() {
        return repository.findAll();
    }


    // Other service methods as needed
}
