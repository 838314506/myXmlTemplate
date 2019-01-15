package com.lz.snappy.myXmlTemplate.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class XmlUtil {

	// 用于判断字符串是否为空，返回拼接内容
	public static String strIsNull(String element) {
		return element == null ? "" : element;
	}

	// 用于判断日期是否为空，返回拼接内容
	public static String dateIsNull(LocalDateTime element) {
		if (element == null) {
			return "";
		}
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return element.format(pattern);
	}

}
