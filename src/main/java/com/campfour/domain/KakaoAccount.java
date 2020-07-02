package com.campfour.domain;

import lombok.ToString;

@ToString
public class KakaoAccount {
    private boolean hasAgeRange;
    private boolean ageRangeNeedsAgreement;
    private boolean hasBirthday;
    private boolean birthdayNeedsAgreement;
    private boolean hasGender;
    private boolean genderNeedsAgreement;

    public KakaoAccount(boolean has_age_range, boolean age_range_needs_agreement, boolean has_birthday, boolean birthday_needs_agreement, boolean has_gender, boolean gender_needs_agreement) {
        this.hasAgeRange = has_age_range;
        this.ageRangeNeedsAgreement = age_range_needs_agreement;
        this.hasBirthday = has_birthday;
        this.birthdayNeedsAgreement = birthday_needs_agreement;
        this.hasGender = has_gender;
        this.genderNeedsAgreement = gender_needs_agreement;
    }
}
