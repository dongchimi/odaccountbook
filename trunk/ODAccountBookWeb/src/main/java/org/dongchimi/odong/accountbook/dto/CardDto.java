package org.dongchimi.odong.accountbook.dto;

import java.io.Serializable;

import org.dongchimi.odong.accountbook.domain.Card;
import org.dongchimi.odong.accountbook.domain.CardCompanyType;
import org.dongchimi.odong.accountbook.domain.CardType;
import org.dongchimi.odong.accountbook.domain.CreditCardPaymentMonthType;
import org.dongchimi.odong.accountbook.domain.DayType;

public class CardDto implements Serializable {

    /** UID */
    private static final long serialVersionUID = -8964126668321628119L;

    /** ID */
    private Long oid;

    /** 카드회사명(신용카드용) */
    private CardCompanyType companyName;

    /** 별명 */
    private String nickName;

    /** 메모 */
    private String memo;

    /** 가계부ID */
    private Long accountBookOid;

    /** 결제은행 */
    private Long assetOid;

    /** 카드 타입 */
    private CardType cardType;

    /** 결제일 (신용카드용) */
    private DayType settlementDay;

    /** 일시불 할부 시작일 월 (신용카드용) */
    private CreditCardPaymentMonthType oncePaymentFromMonthType;

    /** 일시불 할부 시작일 일 (신용카드용) */
    private DayType oncePaymentFromDayType;

    /** 일시불 할부 종료일 월 (신용카드용) */
    private CreditCardPaymentMonthType oncePaymentToMonthType;

    /** 일시불 할부 종료일 일 (신용카드용) */
    private DayType oncePaymentToDayType;

    /** 현금서비스 시작일 월 (신용카드용) */
    private CreditCardPaymentMonthType cashServiceFromMonthType;

    /** 현금서비스 시작일 일 (신용카드용) */
    private DayType cashServiceFromDayType;

    /** 현금서비스 종료일 월 (신용카드용) */
    private CreditCardPaymentMonthType cashServiceToMonthType;

    /** 현금서비스 종료일 일 (신용카드용) */
    private DayType cashServiceToDayType;

    /** 청구금액 (신용카드용) */
    private int creditCardCharge;

    public static CardDto toCardDto(Card card) {
        CardDto dto = new CardDto();
        
        dto.setOid(card.getOid());
        dto.setCompanyName(card.getCompanyName());
        dto.setNickName(card.getNickName());
        dto.setMemo(card.getMemo());
        dto.setAccountBookOid(card.getAccountBookOid());
        dto.setAssetOid(card.getAssetOid());
        dto.setCardType(card.getCardType());
        dto.setSettlementDay(card.getSettlementDay());
        dto.setOncePaymentFromMonthType(card.getOncePaymentFromMonthType());
        dto.setOncePaymentFromDayType(card.getOncePaymentFromDayType());
        dto.setOncePaymentToMonthType(card.getOncePaymentToMonthType());
        dto.setOncePaymentToDayType(card.getOncePaymentToDayType());
        dto.setCashServiceFromMonthType(card.getCashServiceFromMonthType());
        dto.setCashServiceFromDayType(card.getCashServiceFromDayType());
        dto.setCashServiceToMonthType(card.getCashServiceToMonthType());
        dto.setCashServiceToDayType(card.getCashServiceToDayType());
        
        return dto;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
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

    public int getCreditCardCharge() {
        return creditCardCharge;
    }

    public void setCreditCardCharge(int creditCardCharge) {
        this.creditCardCharge = creditCardCharge;
    }

}
