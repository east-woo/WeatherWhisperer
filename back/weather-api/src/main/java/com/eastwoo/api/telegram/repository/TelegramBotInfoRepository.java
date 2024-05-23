package com.eastwoo.api.telegram.repository;


import com.eastwoo.api.telegram.entity.TelegramBotInfo;
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
    // https://squirmm.tistory.com/entry/SpringBoot-Querydsl-%EC%82%AC%EC%9A%A9%EB%B0%A9%EB%B2%95?category=1018066
}
