package org.dongchimi.odong.accountbook.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CreditCardPaymentMonthType {

    MONTH_BEFORE_LAST(-2, "전전월", true, true), //
    LAST_MONTH(-1, "전월", true, true), //
    THIS_MONTH(0, "당월", true, false), //
    LAST_MONTH_SETTLEMENT(1, "전월결제일", false, false), //
    LAST_MONTH_SETTLEMENT_PLUS_1(2, "전월결제일+1일", false, true), //
    MONTH_BEFORE_LAST_SETTLEMENT_PLUS_2(3, "전전월결제일+1영업일+1일", false, true);

    private Integer code;
    private String koreaName;
    private boolean oncePaymentYn;
    private boolean fromMonthYn;

    private CreditCardPaymentMonthType(Integer code, String koreaName, boolean oncePaymentYn,
            boolean fromMonthYn) {
        this.code = code;
        this.koreaName = koreaName;
        this.oncePaymentYn = oncePaymentYn;
        this.fromMonthYn = fromMonthYn;
    }
    
    public static CreditCardPaymentMonthType toCreditCardPaymentMonthType(Integer code) {
        for (CreditCardPaymentMonthType type : CreditCardPaymentMonthType.values()) {
            if (type.getCode() != code) continue;
            
            return type;
        }
        
        return MONTH_BEFORE_LAST;
    }

    public Integer getCode() {
        return code;
    }

    public String getKoreaName() {
        return koreaName;
    }

    public boolean isOncePaymentYn() {
        return oncePaymentYn;
    }

    public boolean isFromMonthYn() {
        return fromMonthYn;
    }

}
