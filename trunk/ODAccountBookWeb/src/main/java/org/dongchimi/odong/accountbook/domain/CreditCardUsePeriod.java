package org.dongchimi.odong.accountbook.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "TB_CREDIT_CARD_USE_PERIOD")
public class CreditCardUsePeriod {

    @Id
    @GeneratedValue
    private Long oid;

    /** 카드사 */
    @Column
    @Enumerated(EnumType.STRING)
    private CardCompanyType cardCompanyType;

    /** 결제일 */
    @Column
    @Enumerated(EnumType.STRING)
    private DayType settlementDay;

    /** 일시불/할부 이용시작월 */
    @Column
    @Enumerated(EnumType.STRING)
    private CreditCardPaymentMonthType useFromMonthType;

    /** 일시불/할부 이용시작일 */
    @Column
    @Enumerated(EnumType.STRING)
    private DayType useFromDayType;

    /** 일시불/할부 이용종료월 */
    @Column
    @Enumerated(EnumType.STRING)
    private CreditCardPaymentMonthType useToMonthType;

    /** 일시불/할부 이용종료일 */
    @Column
    @Enumerated(EnumType.STRING)
    private DayType useToDayType;

    /** 현금서비스 이용시작월 */
    @Column
    @Enumerated(EnumType.STRING)
    private CreditCardPaymentMonthType cashAdvanceUseFromMonthType;

    /** 현금서비스 이용시작일 */
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private DayType cashAdvanceUseFromDayType;

    /** 현금서비스 이용종료월 */
    @Column
    @Enumerated(EnumType.STRING)
    private CreditCardPaymentMonthType cashAdvanceUseToMonthType;

    /** 현금서비스 이용종료일 */
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private DayType cashAdvanceUseToDayType;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public CardCompanyType getCardCompanyType() {
        return cardCompanyType;
    }

    public void setCardCompanyType(CardCompanyType cardCompanyType) {
        this.cardCompanyType = cardCompanyType;
    }

    public DayType getSettlementDay() {
        return settlementDay;
    }

    public void setSettlementDay(DayType settlementDay) {
        this.settlementDay = settlementDay;
    }

    public CreditCardPaymentMonthType getUseFromMonthType() {
        return useFromMonthType;
    }

    public void setUseFromMonthType(CreditCardPaymentMonthType useFromMonthType) {
        this.useFromMonthType = useFromMonthType;
    }

    public DayType getUseFromDayType() {
        return useFromDayType;
    }

    public void setUseFromDayType(DayType useFromDayType) {
        this.useFromDayType = useFromDayType;
    }

    public CreditCardPaymentMonthType getUseToMonthType() {
        return useToMonthType;
    }

    public void setUseToMonthType(CreditCardPaymentMonthType useToMonthType) {
        this.useToMonthType = useToMonthType;
    }

    public DayType getUseToDayType() {
        return useToDayType;
    }

    public void setUseToDayType(DayType useToDayType) {
        this.useToDayType = useToDayType;
    }

    public CreditCardPaymentMonthType getCashAdvanceUseFromMonthType() {
        return cashAdvanceUseFromMonthType;
    }

    public void setCashAdvanceUseFromMonthType(
            CreditCardPaymentMonthType cashAdvanceUseFromMonthType) {
        this.cashAdvanceUseFromMonthType = cashAdvanceUseFromMonthType;
    }

    public DayType getCashAdvanceUseFromDayType() {
        return cashAdvanceUseFromDayType;
    }

    public void setCashAdvanceUseFromDayType(DayType cashAdvanceUseFromDayType) {
        this.cashAdvanceUseFromDayType = cashAdvanceUseFromDayType;
    }

    public CreditCardPaymentMonthType getCashAdvanceUseToMonthType() {
        return cashAdvanceUseToMonthType;
    }

    public void setCashAdvanceUseToMonthType(CreditCardPaymentMonthType cashAdvanceUseToMonthType) {
        this.cashAdvanceUseToMonthType = cashAdvanceUseToMonthType;
    }

    public DayType getCashAdvanceUseToDayType() {
        return cashAdvanceUseToDayType;
    }

    public void setCashAdvanceUseToDayType(DayType cashAdvanceUseToDayType) {
        this.cashAdvanceUseToDayType = cashAdvanceUseToDayType;
    }

}
