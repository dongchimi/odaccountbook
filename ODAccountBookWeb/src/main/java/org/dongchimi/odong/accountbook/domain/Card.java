package org.dongchimi.odong.accountbook.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name = "TB_CARD")
public class Card {

    @Id
    @GeneratedValue
    private Long oid;

    /** 카드회사명 */
    @Column
    private String companyName;

    /** 별명 */
    @Column
    private String nickName;

    /** 메모 */
    @Column
    private String memo;

    /** 가계부ID */
    @Column
    private Long accountBookOid;

    /** 결제은행 */
    @Column
    private Long assetOid;

    /** 카드 타입 */
    @Column
    @Enumerated(EnumType.STRING)
    private CardType cardType;

    /** 결제일 (신용카드용) */
    @Column(nullable = true)
    private Integer settlementDay;

    /** 일시불 할부 시작일 월 (신용카드용) */
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private CreditCardPaymentMonthType oncePaymentMonthType;

    /** 일시불 할부 시작일 일 (신용카드용) */
    @Column(nullable = true)
    private Integer oncePaymentDay;

    /** 현금서비스 시작일 (신용카드용) */
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private CreditCardPaymentMonthType creditCardCashServiceType;

    /** 청구금액 (신용카드용) */
    @Transient
    private int creditCardCharge;

    public static Card newCreditCard(String companyName, String nickName, Asset bank,
            int settlementDay) {
        return new Card(companyName, nickName, CardType.CREDIT_CARD, bank, settlementDay);
    }

    public static Card newCheckCard(String companyName, String nickName, Asset bank) {
        return new Card(companyName, nickName, CardType.CHECK_CARD, bank);
    }

    private Card(String companyName, String nickName, CardType cardType, Asset bank) {
        this.companyName = companyName;
        this.nickName = nickName;
        this.cardType = cardType;
        this.creditCardCharge = 0;
        this.oncePaymentMonthType = CreditCardPaymentMonthType.MONTH_BEFORE_LAST;
        this.oncePaymentDay = 27;
        this.creditCardCashServiceType = CreditCardPaymentMonthType.MONTH_BEFORE_LAST_PLUS_2;
    }

    private Card(String companyName, String nickName, CardType cardType, Asset bank,
            int settlementDay) {
        this.companyName = companyName;
        this.nickName = nickName;
        this.cardType = cardType;
        this.settlementDay = settlementDay;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public Integer getSettlementDay() {
        return settlementDay;
    }

    public void setSettlementDay(Integer settlementDay) {
        this.settlementDay = settlementDay;
    }

    public int getCreditCardCharge() {
        return creditCardCharge;
    }

    public void setCreditCardCharge(int creditCardCharge) {
        this.creditCardCharge = creditCardCharge;
    }

    public CreditCardPaymentMonthType getOncePaymentMonthType() {
        return oncePaymentMonthType;
    }

    public void setOncePaymentMonthType(CreditCardPaymentMonthType oncePaymentMonthType) {
        this.oncePaymentMonthType = oncePaymentMonthType;
    }

    public Integer getOncePaymentDay() {
        return oncePaymentDay;
    }

    public void setOncePaymentDay(Integer oncePaymentDay) {
        this.oncePaymentDay = oncePaymentDay;
    }

    public CreditCardPaymentMonthType getCreditCardCashServiceType() {
        return creditCardCashServiceType;
    }

    public void setCreditCardCashServiceType(CreditCardPaymentMonthType creditCardCashServiceType) {
        this.creditCardCashServiceType = creditCardCashServiceType;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getAccountBookOid() {
        return accountBookOid;
    }

    public void setAccountBookOid(Long accountBookOid) {
        this.accountBookOid = accountBookOid;
    }

    public Long getAssetOid() {
        return assetOid;
    }

    public void setAssetOid(Long assetOid) {
        this.assetOid = assetOid;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

}
