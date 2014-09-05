package org.dongchimi.odong.accountbook.web.util;

public class NumberUtil {
	
	public static int parseInt(String obj) {
		int i = 0;
		try {
			i = Integer.valueOf(obj);
		} catch (NumberFormatException e) {
		}
		
		return i;
	}
}
