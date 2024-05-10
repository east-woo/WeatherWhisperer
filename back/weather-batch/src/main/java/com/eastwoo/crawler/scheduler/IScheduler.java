package com.eastwoo.crawler.scheduler;

/**
 * Please explain the class!!
 *
 * @author : dongwoo
 * @fileName : IScheduler
 * @since : 2024-04-24
 */
public interface IScheduler {

    /*초단기 실황 조회*/
    public void getUltraSrtNcst();

    /*초단기 예보 조회*/
    public void getUltraSrtFcst();

    /*단기 예보 조회*/
    public void getVilageFcst();

    /*예보 버전 조회*/
    public void getFcstVersion();

}
