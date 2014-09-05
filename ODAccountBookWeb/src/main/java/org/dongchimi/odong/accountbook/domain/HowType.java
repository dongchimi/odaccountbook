package org.dongchimi.odong.accountbook.domain;

public enum HowType {
	IN("수입"),
	OUT("지출"),
	SAVING("저축"),
	TRANSFER("이체");
	
	private String koreaName;
	
	private HowType(String koreaName) {
		this.koreaName = koreaName;
	}

	public String getKoreaName() {
		return koreaName;
	}
	
	@Override
	public String toString() {
		return koreaName;
	}
}
