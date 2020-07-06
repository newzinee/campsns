package com.campfour.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class GoogleConfig {

    @Value("${google.key.web.client}")
    private String webClientKey;

    @Value("${google.key.web.secret}")
    private String webSecretKey;
}
