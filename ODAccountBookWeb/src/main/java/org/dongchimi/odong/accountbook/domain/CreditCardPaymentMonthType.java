package org.dongchimi.odong.accountbook.domain;

public enum CreditCardPaymentMonthType {

    MONTH_BEFORE_LAST("BEFORE_LAST", "전전월", true), //
    LAST_MONTH("LAST", "전월", true), //
    MONTH_BEFORE_LAST_PLUS_2("PLUS_2", "전전월결제일+1영업일+1일", false), //
    MONTH_BEFORE_LAST_PLUS_1("PLUS_1", "전전월결제일+1일", false);

    private String code;
    private String koreaName;
    private boolean oncePaymentYn;

    private CreditCardPaymentMonthType(String code, String koreaName, boolean oncePaymentYn) {
        this.code = code;
        this.koreaName = koreaName;
        this.oncePaymentYn = oncePaymentYn;
    }

    public String getCode() {
        return code;
    }

    public String getKoreaName() {
        return koreaName;
    }

    public boolean isOncePaymentYn() {
        return oncePaymentYn;
    }

}
