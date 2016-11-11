package com.oneflyingleaf.core.util;

public class CommonUtils {
	
	/**
	 * 判定可变参数是否为空
	 * @param t
	 * @return
	 */
	public static <T> boolean isEmpty(T...t){
		return t == null || t.length == 0;
	}
}
