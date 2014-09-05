package org.dongchimi.odong.accountbook.domain;

public enum CreditCardOncePaymentDayType {
	DAY_1("1일"),
	DAY_2("2일"),
	DAY_3("3일"),
	DAY_4("4일"),
	DAY_5("5일"),
	DAY_6("6일"),
	DAY_7("7일"),
	DAY_8("8일"),
	DAY_9("9일"),
	DAY_10("10일"),
	DAY_11("11일"),
	DAY_12("12일"),
	DAY_13("13일"),
	DAY_14("14일"),
	DAY_15("15일"),
	DAY_16("16일"),
	DAY_17("17일"),
	DAY_18("18일"),
	DAY_19("19일"),
	DAY_20("20일"),
	DAY_21("21일"),
	DAY_22("22일"),
	DAY_23("23일"),
	DAY_24("24일"),
	DAY_25("25일"),
	DAY_26("26일"),
	DAY_27("27일"),
	DAY_28("28일"),
	DAY_29("29일"),
	DAY_30("30일"),
	DAY_31("31일");
	
	private String description;
	
	private CreditCardOncePaymentDayType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
