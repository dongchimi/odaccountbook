package org.dongchimi.odong.accountbook.dto;

import java.io.Serializable;

import org.dongchimi.odong.accountbook.domain.Card;
import org.dongchimi.odong.accountbook.domain.CardCompanyType;
import org.dongchimi.odong.accountbook.domain.CreditCardPaymentMonthType;
import org.dongchimi.odong.accountbook.domain.DayType;

public class CardDtoForRegister implements Serializable {

    /** UID */
    private static final long serialVersionUID = -8371152081216075159L;

    /** 카드회사명(신용카드용) */
    private String companyName;

    /** 별명 */
    private String nickName;

    /** 메모 */
    private String memo;

    /** 결제은행 */
    private Long assetOid;

    /** 결제일 (신용카드용) */
    private Integer settlementDay;

    /** 일시불 할부 시작일 월 (신용카드용) */
    private Integer oncePaymentFromMonthType;

    /** 일시불 할부 시작일 일 (신용카드용) */
    private Integer oncePaymentFromDayType;

    /** 일시불 할부 종료일 월 (신용카드용) */
    private Integer oncePaymentToMonthType;

    /** 일시불 할부 종료일 일 (신용카드용) */
    private Integer oncePaymentToDayType;

    /** 현금서비스 시작일 월 (신용카드용) */
    private Integer cashServiceFromMonthType;

    /** 현금서비스 시작일 일 (신용카드용) */
    private Integer cashServiceFromDayType;

    /** 현금서비스 종료일 월 (신용카드용) */
    private Integer cashServiceToMonthType;

    /** 현금서비스 종료일 일 (신용카드용) */
    private Integer cashServiceToDayType;

    public Card toCard() {
        Card card = new Card();

        card.setCompanyName(CardCompanyType.toCardCompanyType(this.companyName));
        card.setNickName(this.nickName);
        card.setMemo(this.memo);
        card.setAssetOid(this.assetOid);
        card.setSettlementDay(DayType.toDayType(this.settlementDay));
        card.setOncePaymentFromMonthType(CreditCardPaymentMonthType.toCreditCardPaymentMonthType(this.oncePaymentFromMonthType));
        card.setOncePaymentFromDayType(DayType.toDayType(this.oncePaymentFromDayType));
        card.setOncePaymentToMonthType(CreditCardPaymentMonthType.toCreditCardPaymentMonthType(this.oncePaymentToMonthType));
        card.setOncePaymentToDayType(DayType.toDayType(this.oncePaymentToDayType));
        card.setCashServiceFromMonthType(CreditCardPaymentMonthType.toCreditCardPaymentMonthType(this.cashServiceFromMonthType));
        card.setCashServiceToMonthType(CreditCardPaymentMonthType.toCreditCardPaymentMonthType(this.cashServiceToMonthType));
        
        if (this.cashServiceFromDayType > 0) {
            card.setCashServiceFromDayType(DayType.toDayType(this.cashServiceFromDayType));
        }
        if (this.cashServiceToDayType > 0) {
            card.setCashServiceToDayType(DayType.toDayType(this.cashServiceToDayType));
        }

        return card;
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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Long getAssetOid() {
        return assetOid;
    }

    public void setAssetOid(Long assetOid) {
        this.assetOid = assetOid;
    }

    public Integer getSettlementDay() {
        return settlementDay;
    }

    public void setSettlementDay(Integer settlementDay) {
        this.settlementDay = settlementDay;
    }

    public Integer getOncePaymentFromMonthType() {
        return oncePaymentFromMonthType;
    }

    public void setOncePaymentFromMonthType(Integer oncePaymentFromMonthType) {
        this.oncePaymentFromMonthType = oncePaymentFromMonthType;
    }

    public Integer getOncePaymentFromDayType() {
        return oncePaymentFromDayType;
    }

    public void setOncePaymentFromDayType(Integer oncePaymentFromDayType) {
        this.oncePaymentFromDayType = oncePaymentFromDayType;
    }

    public Integer getOncePaymentToMonthType() {
        return oncePaymentToMonthType;
    }

    public void setOncePaymentToMonthType(Integer oncePaymentToMonthType) {
        this.oncePaymentToMonthType = oncePaymentToMonthType;
    }

    public Integer getOncePaymentToDayType() {
        return oncePaymentToDayType;
    }

    public void setOncePaymentToDayType(Integer oncePaymentToDayType) {
        this.oncePaymentToDayType = oncePaymentToDayType;
    }

    public Integer getCashServiceFromMonthType() {
        return cashServiceFromMonthType;
    }

    public void setCashServiceFromMonthType(Integer cashServiceFromMonthType) {
        this.cashServiceFromMonthType = cashServiceFromMonthType;
    }

    public Integer getCashServiceFromDayType() {
        return cashServiceFromDayType;
    }

    public void setCashServiceFromDayType(Integer cashServiceFromDayType) {
        this.cashServiceFromDayType = cashServiceFromDayType;
    }

    public Integer getCashServiceToMonthType() {
        return cashServiceToMonthType;
    }

    public void setCashServiceToMonthType(Integer cashServiceToMonthType) {
        this.cashServiceToMonthType = cashServiceToMonthType;
    }

    public Integer getCashServiceToDayType() {
        return cashServiceToDayType;
    }

    public void setCashServiceToDayType(Integer cashServiceToDayType) {
        this.cashServiceToDayType = cashServiceToDayType;
    }

}
