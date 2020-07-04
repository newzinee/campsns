package com.campfour.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class GoogleConfig {

    @Value("${google.key.web}")
    private String webKey;

    @Value("${google.key.android}")
    private String androidKey;

    @Value("${google.key.ios}")
    private String iosKey;

}
