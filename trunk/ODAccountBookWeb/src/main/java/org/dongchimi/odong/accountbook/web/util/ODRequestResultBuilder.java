package org.dongchimi.odong.accountbook.web.util;

import java.util.HashMap;
import java.util.Map;

public class ODRequestResultBuilder {

	public static ODRequestResult getSuccessRequestResult() {
		ODRequestResult result = new ODRequestResult();
		result.setSuccess(true);
		return result;
	}
	
	public static ODRequestResult getSuccessRequestResult(String name, Object value) {
		ODRequestResult result = new ODRequestResult();
		result.setSuccess(true);
		
		Map<String, Object> valueMap = new HashMap<String, Object>();
		valueMap.put(name, value);
		result.setValue(valueMap);
		return result;
	}
	
	public static ODRequestResult getSuccessRequestResult(Object obj) {
		ODRequestResult result = new ODRequestResult();
		result.setSuccess(true);
		result.setValue(obj);
		return result;
	}
	
	public static ODRequestResult getFailRequestResult() {
		ODRequestResult result = new ODRequestResult();
		result.setSuccess(false);
		return result;
	}

	public static ODRequestResult getFailRequestResult(ODException e) {
		ODRequestResult result = new ODRequestResult();
		result.setSuccess(false);
		result.setErrorMessage1(e.getMessage());
		return result;
	}
}
