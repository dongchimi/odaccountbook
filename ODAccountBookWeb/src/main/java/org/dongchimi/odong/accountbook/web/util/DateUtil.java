package org.dongchimi.odong.accountbook.web.util;

import java.util.Calendar;
import java.util.Locale;

import org.thymeleaf.util.DateUtils;

public class DateUtil {
	
	public static String getStartDateByBaseDay(int baseDate) {
		Calendar now = DateUtils.createNow();
		int today = NumberUtil.parseInt(DateUtils.format(now, "dd", Locale.KOREA));
		
		if (today <= baseDate) {
			now.add(Calendar.MONTH, 1);
		}
		
		Calendar startDateCalendar = DateUtils.create(now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1, 1);
		return DateUtils.format(startDateCalendar, "YYYYMMdd", Locale.KOREA);
	}
	
	public static String getEndDateByBaseDay(int baseDate) {
		Calendar now = DateUtils.createNow();
		int today = NumberUtil.parseInt(DateUtils.format(now, "dd", Locale.KOREA));
		
		if (today <= baseDate) {
			now.add(Calendar.MONTH, 1);
		}
		
		Calendar startDateCalendar = DateUtils.create(now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1, 1);
		startDateCalendar.add(Calendar.MONTH, 1);
		startDateCalendar.add(Calendar.DATE, -1);
		return DateUtils.format(startDateCalendar, "YYYYMMdd", Locale.KOREA);
	}
}
