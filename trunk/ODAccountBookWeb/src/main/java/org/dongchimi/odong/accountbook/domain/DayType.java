package org.dongchimi.odong.accountbook.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DayType {

    DAY_1(1, "1일"), //
    DAY_2(2, "2일"), //
    DAY_3(3, "3일"), //
    DAY_4(4, "4일"), //
    DAY_5(5, "5일"), //
    DAY_6(6, "6일"), //
    DAY_7(7, "7일"), //
    DAY_8(8, "8일"), //
    DAY_9(9, "9일"), //
    DAY_10(10, "10일"), //
    DAY_11(11, "11일"), //
    DAY_12(12, "12일"), //
    DAY_13(13, "13일"), //
    DAY_14(14, "14일"), //
    DAY_15(15, "15일"), //
    DAY_16(16, "16일"), //
    DAY_17(17, "17일"), //
    DAY_18(18, "18일"), //
    DAY_19(19, "19일"), //
    DAY_20(20, "20일"), //
    DAY_21(21, "21일"), //
    DAY_22(22, "22일"), //
    DAY_23(23, "23일"), //
    DAY_24(24, "24일"), //
    DAY_25(25, "25일"), //
    DAY_26(26, "26일"), //
    DAY_27(27, "27일"), //
    DAY_28(28, "28일"), //
    DAY_29(29, "29일"), //
    DAY_30(30, "30일"), //
    DAY_31(31, "말일");

    private Integer code;
    private String koreaName;

    private DayType(Integer code, String koreaName) {
        this.code = code;
        this.koreaName = koreaName;
    }
    
    public static DayType toDayType(Integer code) {
        for (DayType type : DayType.values()) {
            if (type.getCode() != code) continue;
            
            return type;
        }
        
        return DAY_1;
    }

    public Integer getCode() {
        return code;
    }

    public String getKoreaName() {
        return koreaName;
    }

}
