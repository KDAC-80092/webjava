package com.sunbeam.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class DateTimeUtil {

	public static java.sql.Date stringToSqlDate(String s) {
		java.sql.Date d = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			d = new java.sql.Date(sdf.parse(s).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	public static String utilDateToString(java.util.Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String s = sdf.format(d);
		return s;
	}
	
	public static String timeStampToString(Timestamp ts)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(ts);
	}
}
