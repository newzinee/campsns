package com.campfour.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {

    private String roadAddr;
    private String jibunAddr;
    private int zipNo;
    private String siName;
    private String sggName;
    private String emdName;
    private String liName;
    private String roadName;
    private String buildMnNo;
    private String buildSlNo;
    private String jibunMnNo;
    private String jibunSlNo;
    private String buildName;

    @Builder
    public Address(String roadAddr, String jibunAddr) {
        this.roadAddr = roadAddr;
        this.jibunAddr = jibunAddr;
    }
}
