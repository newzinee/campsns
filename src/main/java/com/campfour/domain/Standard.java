package com.campfour.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Standard {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "standard_id")
    private Long id;
    private String name;
    private String image;

    @Builder
    public Standard(String name, String image) {
        this.name = name;
        this.image = image;
    }
}
