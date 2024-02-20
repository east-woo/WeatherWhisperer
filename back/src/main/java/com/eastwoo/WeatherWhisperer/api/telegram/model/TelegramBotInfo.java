package com.eastwoo.WeatherWhisperer.api.telegram.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Please explain the class!!
 *
 * @author : dongwoo
 * @fileName : TelegramBotInfo
 * @since : 2024-02-05
 */
@Entity
@Data
public class TelegramBotInfo {
    @Id
    private String botToken;

    private Long chatId;

}