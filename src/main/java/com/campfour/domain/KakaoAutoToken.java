package com.campfour.domain;

import lombok.ToString;

@ToString
public class KakaoAutoToken {

    private String accessToken;
    private String tokenType;
    private String refreshToken;
    private Integer expiresIn;
    private Integer refreshTokenExpiresIn;
    private String scope;

    public KakaoAutoToken(String access_token, String token_type, String refresh_token, Integer expires_in, Integer refresh_token_expires_in, String scope) {
        this.accessToken = access_token;
        this.tokenType = token_type;
        this.refreshToken = refresh_token;
        this.expiresIn = expires_in;
        this.refreshTokenExpiresIn = refresh_token_expires_in;
        this.scope = scope;
    }
}
