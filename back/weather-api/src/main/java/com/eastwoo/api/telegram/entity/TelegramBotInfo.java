package com.eastwoo.api.telegram.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Please explain the class!!
 *
 * @author : dongwoo
 * @fileName : TelegramBotInfo
 * @since : 2024-02-05
 */
@Entity
@Table(name = "tb_telegram_bot_info")
@Data
public class TelegramBotInfo {
    @Id
    private String botToken;

    private Long chatId;

}