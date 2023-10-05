package com.ecom.users.commonUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang.StringUtils;

import com.onlineShop.example.commonUtilMethods.CommonConstant;

public class SecurityHelper {
	
	
	public static class MessageDiagestUtil
	{
		
		
		public static String getHash(String str) throws NoSuchAlgorithmException
		{
			String result = null;
			if(StringUtils.isNotBlank(str))
			{
				MessageDigest mes = MessageDigest.getInstance(CommonConstant.SHA256);
				
				byte[] by = mes.digest(str.getBytes());
				
				result = byteArrayTohex(by);
			}
			
			return result;
		}
	}
	
	public static String byteArrayTohex(byte[] by)
	{
		StringBuilder sb = new StringBuilder(by.length*2);
		for(byte a : by)
		{
			sb.append(String.format(CommonConstant.HEX_B_FMT, a));
		}
		 return sb.toString();		
	}

}
