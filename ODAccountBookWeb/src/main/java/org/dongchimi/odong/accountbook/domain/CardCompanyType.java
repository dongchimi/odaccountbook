package org.dongchimi.odong.accountbook.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CardCompanyType {

    SHIN_HAN("SH", "신한카드");

    private String code;
    private String koreaName;

    private CardCompanyType(String code, String koreaName) {
        this.code = code;
        this.koreaName = koreaName;
    }
    
    public static CardCompanyType toCardCompanyType(String code) {
        return SHIN_HAN;
    }

    public String getCode() {
        return code;
    }

    public String getKoreaName() {
        return koreaName;
    }

}
