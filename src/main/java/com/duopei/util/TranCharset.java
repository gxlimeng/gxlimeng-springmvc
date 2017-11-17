package com.duopei.util;

public class TranCharset {

	private final static String[] encodes = new String[] { "GB2312", "ISO-8859-1", "GBK", "UTF-8" };

	/** 
	* 判断字符串的编码 
	* 
	* @param str 
	* @return 
	*/
	public static String getEncoding(String str) {
		if(null == str){
			return "";
		}
		String encode = "";
		try {
			for (int i = 0; i < encodes.length; i++) {
				if (str.equals(new String(str.getBytes(encodes[i]), encodes[i]))) {
					encode = encodes[i];
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return encode;
	}
}
