package org.dongchimi.odong.accountbook.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum HowType {
    IN("IN", "수입"), //
    OUT("OUT", "지출"), //
    SAVING("SAVING", "저축"), //
    TRANSFER("TRANSFER", "이체");

    private String code;
    private String koreaName;

    private HowType(String code, String koreaName) {
        this.code = code;
        this.koreaName = koreaName;
    }

    public static HowType toHowType(String howTypeName) {
        if (IN.getCode().equals(howTypeName)) {
            return HowType.IN;
        } else if (OUT.getCode().equals(howTypeName)) {
            return HowType.OUT;
        } else if (SAVING.getCode().equals(howTypeName)) {
            return HowType.SAVING;
        } else {
            return HowType.TRANSFER;
        }
    }

    public String getCode() {
        return code;
    }

    public String getKoreaName() {
        return koreaName;
    }

}
