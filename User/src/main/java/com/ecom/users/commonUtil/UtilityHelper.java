package com.ecom.users.commonUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class UtilityHelper {
	
	
	
	public static SimpleDateFormat getSimpleDateFormat(String pattern)
	{
		SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.ENGLISH);
		
		return format;
	}
	
	
	
	public static class Dateutil
	{
		
		
		public static String getStringFormatDate(Date date, String pattern)
		{
			if(date == null)
				return null;
			if(pattern == null)
				return null;
			SimpleDateFormat st = getSimpleDateFormat(pattern);
			return st.format(date);
			
		}
	}

}
