package com.campfour.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class KakaoConfig {

    @Value("${kakao.key.rest}")
    private String restApiKey;

    @Value("${kakao.key.js}")
    private String jsKey;

    @Value("${kakao.key.admin")
    private String adminKey;

}
