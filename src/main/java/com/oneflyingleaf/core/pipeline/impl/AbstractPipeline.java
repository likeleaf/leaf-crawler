package com.oneflyingleaf.core.pipeline.impl;

import java.util.List;
import java.util.Map;

import com.oneflyingleaf.core.pipeline.Pipeline;

public abstract class AbstractPipeline implements Pipeline{

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> void save(T t) {
		if(t instanceof Map){
			
			this.saveMap((Map)t);
		}else if(t instanceof List){
		
			this.saveList((List)t);
		}else{
			
			this.saveJavaBean(t);
		}
	}
	
	/**
	 * 作为map保存 钩子
	 * @param map
	 */
	protected abstract void saveMap(Map<Object,Object> map) ;

	/**
	 * 作为list保存 钩子
	 * @param list
	 */
	protected abstract void saveList(List<Object> list);
	
	/**
	 * 作为javabean形式保存 钩子
 	 * @param t
	 */
	protected abstract <T> void saveJavaBean(T t);
}
