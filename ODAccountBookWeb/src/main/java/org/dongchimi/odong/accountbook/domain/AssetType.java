package org.dongchimi.odong.accountbook.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AssetType {

    CASH_ASSETS("CASH", "현금자산"), //
    FINANCIAL_ASSETS("FINANCIAL", "금융자산"), //
    FIXED_ASSETS("FIXED", "고정자산"), //
    DEBT("DEBT", "부채");

    private String code;
    private String koreaName;

    private AssetType(String code, String koreaName) {
        this.code = code;
        this.koreaName = koreaName;
    }

    public static AssetType toAssetType(String assetTypeCode) {
        if (CASH_ASSETS.getCode().equals(assetTypeCode)) {
            return CASH_ASSETS;
        } else if (FINANCIAL_ASSETS.getCode().equals(assetTypeCode)) {
            return FINANCIAL_ASSETS;
        } else if (FIXED_ASSETS.getCode().equals(assetTypeCode)) {
            return FIXED_ASSETS;
        } else {
            return DEBT;
        }
    }

    public String getCode() {
        return code;
    }

    public String getKoreaName() {
        return koreaName;
    }

}
