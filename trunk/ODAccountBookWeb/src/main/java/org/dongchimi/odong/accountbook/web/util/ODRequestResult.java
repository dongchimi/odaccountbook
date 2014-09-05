package org.dongchimi.odong.accountbook.web.util;


public class ODRequestResult {
	
	// 서버 실행 성경 여부
	private boolean success;
	// 결과값 
	private Object value;
	// 에러메시지
	private String errorMessage1;
	private String errorMessage2;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getErrorMessage1() {
		return errorMessage1;
	}
	public void setErrorMessage1(String errorMessage1) {
		this.errorMessage1 = errorMessage1;
	}
	public String getErrorMessage2() {
		return errorMessage2;
	}
	public void setErrorMessage2(String errorMessage2) {
		this.errorMessage2 = errorMessage2;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
}
