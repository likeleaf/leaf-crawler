package com.oneflyingleaf.core.util;

public class CommonUtils {
	
	/**
	 * �ж��ɱ�����Ƿ�Ϊ��
	 * @param t
	 * @return
	 */
	public static <T> boolean isEmpty(T...t){
		return t == null || t.length == 0;
	}
}
