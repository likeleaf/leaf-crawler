package com.oneflyingleaf.core.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ConfigUtils {
	private static Map<String ,ResourceBundle> rbs = new LinkedHashMap<String ,ResourceBundle>();
	
	/**
	 * 从资源中获取值，忽略key的大小写
	 * @param resourceName 资源名
	 * @param key 键
	 * @return
	 */
	private static String getValue(String resourceName,String key){
		ResourceBundle rb = rbs.get("resourceName");
		
		if(rb == null){
			rb = ResourceBundle.getBundle(resourceName);
			rbs.put(resourceName, rb);
		}
		
		rb.getString(key.toUpperCase());
		
		
		return rb.getString(key.toUpperCase());
	}
	
	/**
	 * 是否开启页面的正则
	 * @return
	 */
	public static boolean defaultPageRegularON(){
		return "on".equals(getValue("page", "regular"));
	}
	
	/**
	 * page正则匹配时是否只匹配一次
	 * @return
	 */
	public static boolean defaultSitePatternOne(){
		return "0".equals(getValue("site","attern.one"));
	}
	
}
