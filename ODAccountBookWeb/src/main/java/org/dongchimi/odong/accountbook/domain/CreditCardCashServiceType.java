package org.dongchimi.odong.accountbook.domain;

public enum CreditCardCashServiceType {
	PrevPrevMonth("전전월"),
	PrevMonth("전월"),
	PrevPrevMonthPlusOneBusinessDayPlusOneDay("전전월결제일+1영업일+1일"),
	PrevPrevMonthPlusOneDay("전전월결제일+1일");
	
	private String description;
	
	private CreditCardCashServiceType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
