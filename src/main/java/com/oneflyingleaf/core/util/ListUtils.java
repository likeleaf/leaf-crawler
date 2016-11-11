package com.oneflyingleaf.core.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.http.cookie.Cookie;

public class ListUtils {
	
	/**
	 * 将可变参数t转换成list （LinkedList）
	 * @param t 可变参数
	 * @return 转换后的list (LinkedList)
	 */
	public static <T> List<T> variableParamToList(T ... t){
		List<T> list = new LinkedList<T>();
		for(int i = 0;i<t.length;i++){
			list.add(t[i]);
		}
		return list;
	}
	
	/**
	 * 校验集合是否为空
	 * @param list
	 * @return
	 */
	public static <T> boolean isEmpty(List<T> list ){
		return list == null || list.isEmpty();
	}
	
	/**
	 * 校验集合是否为空（集合的某些元素为空，同样校验）
	 * @param list
	 * @return
	 */
	public static <T> boolean isEmptyDeeply(List<T> list){ 
		if(isEmpty(list)){
			return true;
		}
		
		for(T t : list){
			if(t == null){
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 取list中Cookie的键和值组成Map
	 * @param cookies
	 * @return
	 */
	public static Map<String ,String> cookieListToMap(List<Cookie> cookies){
		Map<String ,String > map = new HashMap<String,String>();
		for(Cookie cookie : cookies){
			map.put(cookie.getName(), cookie.getValue());
		}
		return map;
		
	}
}
