package org.dongchimi.odong.accountbook.domain;

/**
 * 권한타입
 * @author dongchimi
 * @since 2014.06.29
 */
public enum AuthType {
	READ_WRITE("읽기/쓰기"),
	READ("읽기");
	
	private String koreaName;
	
	private AuthType(String koreaName) {
		this.koreaName = koreaName;
	}

	public String getKoreaName() {
		return koreaName;
	}

	public void setKoreaName(String koreaName) {
		this.koreaName = koreaName;
	}
}
