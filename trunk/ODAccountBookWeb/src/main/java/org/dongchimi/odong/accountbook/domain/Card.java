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

    /** 카드회사명(신용카드용) */
    @Column(nullable = true)
    private CardCompanyType companyName;

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
    private DayType settlementDay;

    /** 일시불 할부 시작일 월 (신용카드용) */
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private CreditCardPaymentMonthType oncePaymentFromMonthType;

    /** 일시불 할부 시작일 일 (신용카드용) */
    @Column(nullable = true)
    private DayType oncePaymentFromDayType;

    /** 일시불 할부 종료일 월 (신용카드용) */
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private CreditCardPaymentMonthType oncePaymentToMonthType;

    /** 일시불 할부 종료일 일 (신용카드용) */
    @Column(nullable = true)
    private DayType oncePaymentToDayType;

    /** 현금서비스 시작일 월 (신용카드용) */
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private CreditCardPaymentMonthType cashServiceFromMonthType;

    /** 현금서비스 시작일 일 (신용카드용) */
    @Column(nullable = true)
    private DayType cashServiceFromDayType;

    /** 현금서비스 종료일 월 (신용카드용) */
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private CreditCardPaymentMonthType cashServiceToMonthType;

    /** 현금서비스 종료일 일 (신용카드용) */
    @Column(nullable = true)
    private DayType cashServiceToDayType;

    /** 청구금액 (신용카드용) */
    @Transient
    private int creditCardCharge;

    public CardCompanyType getCompanyName() {
        return companyName;
    }

    public void setCompanyName(CardCompanyType companyName) {
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

    public int getCreditCardCharge() {
        return creditCardCharge;
    }

    public void setCreditCardCharge(int creditCardCharge) {
        this.creditCardCharge = creditCardCharge;
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

    public DayType getSettlementDay() {
        return settlementDay;
    }

    public void setSettlementDay(DayType settlementDay) {
        this.settlementDay = settlementDay;
    }

    public CreditCardPaymentMonthType getOncePaymentFromMonthType() {
        return oncePaymentFromMonthType;
    }

    public void setOncePaymentFromMonthType(CreditCardPaymentMonthType oncePaymentFromMonthType) {
        this.oncePaymentFromMonthType = oncePaymentFromMonthType;
    }

    public DayType getOncePaymentFromDayType() {
        return oncePaymentFromDayType;
    }

    public void setOncePaymentFromDayType(DayType oncePaymentFromDayType) {
        this.oncePaymentFromDayType = oncePaymentFromDayType;
    }

    public CreditCardPaymentMonthType getOncePaymentToMonthType() {
        return oncePaymentToMonthType;
    }

    public void setOncePaymentToMonthType(CreditCardPaymentMonthType oncePaymentToMonthType) {
        this.oncePaymentToMonthType = oncePaymentToMonthType;
    }

    public DayType getOncePaymentToDayType() {
        return oncePaymentToDayType;
    }

    public void setOncePaymentToDayType(DayType oncePaymentToDayType) {
        this.oncePaymentToDayType = oncePaymentToDayType;
    }

    public CreditCardPaymentMonthType getCashServiceFromMonthType() {
        return cashServiceFromMonthType;
    }

    public void setCashServiceFromMonthType(CreditCardPaymentMonthType cashServiceFromMonthType) {
        this.cashServiceFromMonthType = cashServiceFromMonthType;
    }

    public DayType getCashServiceFromDayType() {
        return cashServiceFromDayType;
    }

    public void setCashServiceFromDayType(DayType cashServiceFromDayType) {
        this.cashServiceFromDayType = cashServiceFromDayType;
    }

    public CreditCardPaymentMonthType getCashServiceToMonthType() {
        return cashServiceToMonthType;
    }

    public void setCashServiceToMonthType(CreditCardPaymentMonthType cashServiceToMonthType) {
        this.cashServiceToMonthType = cashServiceToMonthType;
    }

    public DayType getCashServiceToDayType() {
        return cashServiceToDayType;
    }

    public void setCashServiceToDayType(DayType cashServiceToDayType) {
        this.cashServiceToDayType = cashServiceToDayType;
    }

}
