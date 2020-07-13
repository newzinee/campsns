package com.campfour.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Option {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private Long id;
    private String name;    // 이름
    private String type;    // 대분류(구분)
    private String code;    // 앱에 저장된 이미지 이름

    @Builder
    public Option(String name, String type, String code) {
        this.name = name;
        this.type = type;
        this.code = code;
    }
}
