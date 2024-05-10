package com.eastwoo.crawler.service;

public interface ExternalApiService {
    /*초단기 실황 조회*/
    public void getUltraSrtNcst();

    /*초단기 예보 조회*/
    public void getUltraSrtFcst();

    /*단기 예보 조회*/
    public void getVilageFcst();

    /*예보 버전 조회*/
    public void getFcstVersion();
}
