package org.dongchimi.odong.accountbook.domain;

public enum CardType {

    CREDIT_CARD("CREDIT", "신용카드"), //
    CHECK_CARD("CHECK", "체크카드");

    private String code;
    private String koreaName;

    private CardType(String code, String koreaName) {
        this.code = code;
        this.koreaName = koreaName;
    }

    public static CardType toCardType(String code) {
        if (code.equals(CREDIT_CARD.getCode())) {
            return CardType.CREDIT_CARD;
        } else {
            return CardType.CHECK_CARD;
        }
    }

    public String getCode() {
        return code;
    }

    public String getKoreaName() {
        return koreaName;
    }

}
