package com.oneflyingleaf.core.context;

import java.util.Map;

import com.oneflyingleaf.core.util.ConfigUtils;

public class CrawlerContext implements LifeCycle{
	//加载相关properties中的内容
	private static Map<String,Map<String,String>> resourceMap = null;
	
	private static boolean defaultPageRegular = false;
	
	/**
	 * 系统启动参数设置
	 */
	public void init(){
		initResouce();
	}
	
	
	/**
	 * 设置配置文件
	 */
	public static void initResouce(){
		defaultPageRegular = ConfigUtils.defaultPageRegularON();
	
	}
	
	
	public static boolean defaultPageRegular(){
		return defaultPageRegular;
	}
	
}
