package com.oneflyingleaf.core.pipeline.impl;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class FilePipeline extends AbstractPipeline {

	@Override
	protected void saveMap(Map<Object, Object> map) {
		if(map == null){
			return ;
		}
		
		Object val = null ;
		
		for(Object key : map.entrySet()){
			val = map.get(key);
			if(val instanceof String){
				
			}else if(val instanceof InputStream){
				
			}
		}
		
		
	}

	@Override
	protected void saveList(List<Object> list) {

	}

	@Override
	protected <T> void saveJavaBean(T t) {
		
	}

}
