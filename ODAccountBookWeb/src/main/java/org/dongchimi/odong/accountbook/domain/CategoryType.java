package org.dongchimi.odong.accountbook.domain;

public enum CategoryType {

	ITEM("항목"), //
	GROUP("그룹");

	private String koreaName;

	private CategoryType(String koreaName) {
		this.koreaName = koreaName;
	}

	public static CategoryType toCategoryType(String categoryTypeName) {
		if (ITEM.toString().equals(categoryTypeName)) {
			return CategoryType.ITEM;
		} else {
			return CategoryType.GROUP;
		}
	}

	public String getKoreaName() {
		return koreaName;
	}

}
