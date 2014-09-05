package org.dongchimi.odong.accountbook.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="TB_CARD")
public class Card {
	
	@Id
	@GeneratedValue
	private Long oid;
	
	/**  카드회사명 */
	private String companyName;
	
	/** 별명 */
	private String nickName;
	
	// 가계부
	@OneToOne(cascade = CascadeType.ALL, targetEntity = ODAccountBook.class)
	private ODAccountBook relatedBook;

	/** 관련은행 */
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Asset.class)
    @JoinColumn(name="asset_oid")
	private Asset relatedBank;
	
	/** 카드 타입 */
	private CardType cardType;
	
	
	/** 결제일 (신용카드용) */
	private Integer settlementDay;
	
	/** 청구금액 (신용카드용)*/
	private int creditCardCharge;
	
	/** 일시불 할부 시작일 월 (신용카드용) */
	private CreditCardOncePaymentMonthType oncePaymentMonthType;
	
	/** 일시불 할부 시작일 일 (신용카드용) */
	private CreditCardOncePaymentDayType oncePaymentDayType;
	
	/** 현금서비스 시작일 (신용카드용) */
	private CreditCardCashServiceType creditCardCashServiceType;
	
	public static Card newCreditCard(String companyName, String nickName, Asset bank, int settlementDay) {
		return new Card(companyName, nickName, CardType.CREDIT_CARD, bank, settlementDay);
	}
	
	public static Card newCheckCard(String companyName, String nickName, Asset bank) {
		return new Card(companyName, nickName, CardType.CHECK_CARD, bank);
	}
	
	private Card(String companyName, String nickName, CardType cardType, Asset bank) {
		this.companyName =  companyName;
		this.nickName = nickName;
		this.relatedBank = bank;
		this.cardType = cardType;
		creditCardCharge = 0;
		oncePaymentMonthType = CreditCardOncePaymentMonthType.PrevPrevMonth;
		oncePaymentDayType = CreditCardOncePaymentDayType.DAY_27;
		creditCardCashServiceType = CreditCardCashServiceType.PrevPrevMonthPlusOneBusinessDayPlusOneDay;
	}
	
	private Card(String companyName, String nickName, CardType cardType, Asset bank, int settlementDay) {
		this.companyName =  companyName;
		this.nickName = nickName;
		this.relatedBank = bank;
		this.cardType = cardType;
		this.settlementDay = settlementDay;
	}
	
	public void out(String when, String what, int howmuch, String who) {
		switch (cardType) {
		case CREDIT_CARD:
			break;
		case CHECK_CARD:
			relatedBank.out(when, what, howmuch, who);
			break;
		default:
			break;
		}

		// TODO 은행용과 카드용이 다른가? 
		//History history = new History(when, what, howmuch, HowType.OUT, who, 0, this);
		//this.histories.add(history);
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

	public Asset getRelatedBank() {
		return relatedBank;
	}

	public void setRelatedBank(Asset relatedBank) {
		this.relatedBank = relatedBank;
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

	public CreditCardOncePaymentMonthType getOncePaymentMonthType() {
		return oncePaymentMonthType;
	}

	public void setOncePaymentMonthType(
			CreditCardOncePaymentMonthType oncePaymentMonthType) {
		this.oncePaymentMonthType = oncePaymentMonthType;
	}

	public CreditCardOncePaymentDayType getOncePaymentDayType() {
		return oncePaymentDayType;
	}

	public void setOncePaymentDayType(
			CreditCardOncePaymentDayType oncePaymentDayType) {
		this.oncePaymentDayType = oncePaymentDayType;
	}

	public CreditCardCashServiceType getCreditCardCashServiceType() {
		return creditCardCashServiceType;
	}

	public void setCreditCardCashServiceType(
			CreditCardCashServiceType creditCardCashServiceType) {
		this.creditCardCashServiceType = creditCardCashServiceType;
	}

	public ODAccountBook getRelatedBook() {
		return relatedBook;
	}

	public void setRelatedBook(ODAccountBook relatedBook) {
		this.relatedBook = relatedBook;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}
}
