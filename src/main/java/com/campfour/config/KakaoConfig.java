package com.campfour.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Data
@Component
public class KakaoConfig {

    @Value("${kakao.key.rest}")
    private String restApiKey;

    @Value("${kakao.key.js}")
    private String jsKey;

    @PostConstruct
    public void init() {
        System.out.println("--------------------KAKAO---------------------");
        System.out.println("restApiKey = " + restApiKey);
        System.out.println("jsKey = " + jsKey);
        System.out.println("---------------------------------------------");
    }
}
