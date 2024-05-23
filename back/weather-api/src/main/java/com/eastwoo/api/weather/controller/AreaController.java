package com.eastwoo.api.weather.controller;


import com.eastwoo.api.weather.service.AreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Please explain the class!!
 *
 * @author : dongwoo
 * @fileName : AreaController
 * @since : 2024-03-28
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/area")
public class AreaController {
    private final AreaService areaService;
    public ResponseEntity<String> getStdgCtpvNmList(){
        return ResponseEntity.status(HttpStatus.OK).body("TEST");
    }
}
