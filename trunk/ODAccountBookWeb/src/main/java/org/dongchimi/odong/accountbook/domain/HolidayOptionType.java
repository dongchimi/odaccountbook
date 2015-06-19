package org.dongchimi.odong.accountbook.domain;

public enum HolidayOptionType {

	THE_DAY("당일"), //
	PREVIOUS_DAY("휴일이전"), //
	NEXT_DAY("휴일다음");

	private String koreaName;

	private HolidayOptionType(String koreaName) {
		this.koreaName = koreaName;
	}

	public static HolidayOptionType toHolidayOptionType(
			String holidayOptionTypeName) {
		if (THE_DAY.toString().equals(holidayOptionTypeName)) {
			return HolidayOptionType.THE_DAY;
		} else if (PREVIOUS_DAY.toString().equals(holidayOptionTypeName)) {
			return HolidayOptionType.PREVIOUS_DAY;
		} else {
			return HolidayOptionType.NEXT_DAY;
		}
	}

	public String getKoreaName() {
		return koreaName;
	}

}
