package com.campfour.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Camp extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "camp_id")
    private Long id;

    private String name;
    private String campType;
    private Location location;
    private Address address;

    // no data. require?
    private String manageNo;
    private String approvalDate;
    private String approvalCancelDate;
    private String stateCode;
    private String closeDate;
    private String holidayStartDate;
    private String reopenDate;
    //

    private String phone;
    private int spotNumber;
    private Double siteSize;
    private Double buildSize;

    //// no data. require?
    private Double facilitySize;
    private String cultureIndustry;
    private String cultureOperator;
    private String areaSection;
    private String floor;
    private String environment;
    private String insuranceIndustry;
    private String buildingPurpose;
    private String aboveStairs;
    private String belowStairs;
    private String roomNumber;
    private String insuranceStartDate;
    private String insuranceEndDate;
    //

    private Integer capacity;
    private Integer parkingCapacity;

    // option을 어떻게 넣을것인가 양방향.
    // 현재 camp-option이 campOption뿐인데 더 추가해야하나?
    // 편의시설 convenienceOption
    // 안전시설 safetyOption
    // 기타부대시설 extraOption
    private String convenienceOptionStr;
    private String safetyOptionStr;
    private String extraOptionStr;


    private String useTime;
    private String charge;
    private String managingAgencyPhone;
    private String managingAgencyName;
    private LocalDate baseDate;
    private String agencyCode;
    private String agencyName;

    @Builder
    public Camp(String name, String campType, Location location, Address address, String phone, int spotNumber, Double siteSize, Double buildSize, Integer capacity, Integer parkingCapacity, String convenienceOptionStr, String safetyOptionStr, String extraOptionStr, String useTime, String charge, String managingAgencyPhone, String managingAgencyName, LocalDate baseDate, String agencyCode, String agencyName) {
        this.name = name;
        this.campType = campType;
        this.location = location;
        this.address = address;
        this.phone = phone;
        this.spotNumber = spotNumber;
        this.siteSize = siteSize;
        this.buildSize = buildSize;
        this.capacity = capacity;
        this.parkingCapacity = parkingCapacity;
        this.convenienceOptionStr = convenienceOptionStr;
        this.safetyOptionStr = safetyOptionStr;
        this.extraOptionStr = extraOptionStr;
        this.useTime = useTime;
        this.charge = charge;
        this.managingAgencyPhone = managingAgencyPhone;
        this.managingAgencyName = managingAgencyName;
        this.baseDate = baseDate;
        this.agencyCode = agencyCode;
        this.agencyName = agencyName;
    }
}
