package com.eastwoo.WeatherWhisperer.api.weather.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Please explain the class!!
 *
 * @author : dongwoo
 * @fileName : WeatherArea
 * @since : 2024-03-28
 */
@Entity
@Table(name = "tb_weather_area")
public class WeatherArea {
    @Id
    @Column(name = "admdst_cd", nullable = false)
    private String admdstCd;

    @Column(name = "grid_x")
    private String gridX;

    @Column(name = "grid_y")
    private String gridY;

    @Column(name = "stdg_ctpv", nullable = false)
    private String stdgCtpv;

    @Column(name = "stdg_sgg")
    private String stdgSgg;

    @Column(name = "stdg_emd")
    private String stdgEmd;

    @Column(name = "lot_hr", nullable = false)
    private String lotHr;

    @Column(name = "lot_mint", nullable = false)
    private String lotMint;

    @Column(name = "lot_scnd", nullable = false)
    private String lotScnd;

    @Column(name = "lat_hr", nullable = false)
    private String latHr;

    @Column(name = "lat_mint", nullable = false)
    private String latMint;

    @Column(name = "lat_scnd", nullable = false)
    private String latScnd;

    @Column(name = "lot_mlls", nullable = false)
    private String lotMlls;

    @Column(name = "lat_mlls", nullable = false)
    private String latMlls;
}
