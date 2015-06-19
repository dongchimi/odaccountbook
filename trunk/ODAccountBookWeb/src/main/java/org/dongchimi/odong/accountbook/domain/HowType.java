package org.dongchimi.odong.accountbook.domain;

public enum HowType {
	IN("수입"), //
	OUT("지출"), //
	SAVING("저축"), //
	TRANSFER("이체");

	private String koreaName;

	private HowType(String koreaName) {
		this.koreaName = koreaName;
	}

	public static HowType toHowType(String howTypeName) {
		if (IN.toString().equals(howTypeName)) {
			return HowType.IN;
		} else if (OUT.toString().equals(howTypeName)) {
			return HowType.OUT;
		} else if (SAVING.toString().equals(howTypeName)) {
			return HowType.SAVING;
		} else {
			return HowType.TRANSFER;
		}
	}

	public String getKoreaName() {
		return koreaName;
	}

}
