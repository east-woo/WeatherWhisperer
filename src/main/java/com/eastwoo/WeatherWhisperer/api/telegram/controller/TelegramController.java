package com.eastwoo.WeatherWhisperer.api.telegram.controller;

import com.eastwoo.WeatherWhisperer.api.telegram.model.TelegramBotInfo;
import com.eastwoo.WeatherWhisperer.api.telegram.service.TelegramBotInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Please explain the class!!
 *
 * @author : dongwoo
 * @fileName : TelegramController
 * @since : 2024-02-05
 */
@RestController
public class TelegramController {
    @Autowired
    private TelegramBotInfoService botInfoService;

    @PostMapping("/save-bot-info")
    public TelegramBotInfo saveBotInfo(@RequestBody TelegramBotInfo botInfo) {
        System.out.println(botInfo.toString());
        return botInfoService.saveTelegramBotInfo(botInfo);
    }
}
