package com.campfour.controller;

import com.campfour.config.KakaoConfig;
import com.campfour.domain.KakaoAutoToken;
import com.campfour.domain.KakaoUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class OAuthController {

    private final String KAKAO_OAUTH_TOKEN_URL = "https://kauth.kakao.com/oauth/token";
    private final String KAKAO_USER_ACCESS_INFO_URL = "https://kapi.kakao.com/v2/user/me";
    private final String REDIRECT_URI = "http://localhost:8081/oauth/kakao";
    private final RestTemplate restTemplate;
    private final KakaoConfig kakaoConfig;

    public OAuthController(RestTemplateBuilder restTemplateBuilder, KakaoConfig kakaoConfig) {
        this.restTemplate = restTemplateBuilder.build();
        this.kakaoConfig = kakaoConfig;
    }

    @GetMapping("/oauth/kakao")
    public String kakaoOAuthGetToken(String code) {

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", kakaoConfig.getRestApiKey());
        params.add("redirect_uri", REDIRECT_URI);
        params.add("code", code);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);

        HttpEntity<?> httpEntity = new HttpEntity<>(params, httpHeaders);

        ResponseEntity<KakaoAutoToken> response;
        try {
            response = restTemplate.postForEntity(KAKAO_OAUTH_TOKEN_URL, httpEntity, KakaoAutoToken.class);
            log.info(response.getBody().toString());
        } catch (HttpClientErrorException e) {
            log.info(e.getMessage());
        }

        return "test";
    }

    @GetMapping("/kakao/user/info")
    public void info(String accessToken) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
        httpHeaders.set(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken); // access token 사용

        HttpEntity<?> httpEntity = new HttpEntity(httpHeaders);
        ResponseEntity<KakaoUserInfo> response = restTemplate.postForEntity(KAKAO_USER_ACCESS_INFO_URL, httpEntity, KakaoUserInfo.class);

        log.info("response: " + response);
    }

}
