package com.hlg.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	public static String date2String(Date date) {
		if (date == null) {
			return "";
		}
		return format.format(date);
	}

	/**
	 * 将字符串转成日期格式
	 * 
	 * @param date
	 * @return
	 */
	public static Date string2Date(String date) {
		if (date == null || "".equals(date)) {
			return new Date();
		}
		try {
			return format.parse(date);
		} catch (ParseException e) {
			return new Date();
		}
	}

	public static Date string2DateNull(String date) {
		if (date == null || "".equals(date)) {
			return null;
		}
		try {
			return format.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
}
