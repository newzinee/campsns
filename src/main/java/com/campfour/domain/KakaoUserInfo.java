package com.campfour.domain;

import lombok.ToString;

import java.time.LocalDateTime;

@ToString
public class KakaoUserInfo {
    private Long id;
    private LocalDateTime connectedAt;
    private KakaoAccount kakaoAccount;

    public KakaoUserInfo(Long id, LocalDateTime connected_at, KakaoAccount kakao_account) {
        this.id = id;
        this.connectedAt = connected_at;
        this.kakaoAccount = kakao_account;
    }
}
