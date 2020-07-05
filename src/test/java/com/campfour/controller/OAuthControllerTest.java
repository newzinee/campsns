package com.campfour.controller;

import com.campfour.Application;
import com.campfour.config.GoogleConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest(properties = {Application.APPLICATION_LOCATIONS}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("local")
class OAuthControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private GoogleConfig googleConfig;

    @Test
    void googleOAuthTest() {
//        https://accounts.google.com/o/oauth2/v2/auth?
//        response_type=code&
//                client_id=424911365001.apps.googleusercontent.com&
//                scope=openid%20email&
//                redirect_uri=https%3A//oauth2.example.com/code&
//                state=security_token%3D138r5719ru3e1%26url%3Dhttps%3A%2F%2Foauth2-login-demo.example.com%2FmyHome&
//                login_hint=jsmith@example.com&
//        nonce=0394852-3190485-2490358&
//                hd=example.com

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://accounts.google.com/o/oauth2/v2/auth")
                .queryParam("response_type", "code")
                .queryParam("client_id", googleConfig.getWebKey())
                .queryParam("redirect_uri", "http://localhost:8081/oauth/google");

        System.out.println("builder.toUriString() = " + builder.toUriString());

        ResponseEntity<String> response = restTemplate.getForEntity(builder.toUriString(), String.class);
//        System.out.println("response = " + response.getBody());

    }

}