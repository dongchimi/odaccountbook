package org.dongchimi.odong.accountbook.domain;

public enum CreditCardOncePaymentMonthType {
	PrevPrevMonth("전전월"),
	PrevMonth("전월");
	
	private String description;
	
	private CreditCardOncePaymentMonthType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
