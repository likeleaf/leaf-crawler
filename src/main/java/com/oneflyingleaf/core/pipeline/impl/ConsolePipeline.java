package com.oneflyingleaf.core.pipeline.impl;

import java.util.List;
import java.util.Map;

/**
 * 控制台输出
 * @author leaf
 *
 */
public class ConsolePipeline  extends AbstractPipeline{

	@Override
	protected void saveMap(Map<Object, Object> map) {
		System.out.println(map);
	}

	@Override
	protected void saveList(List<Object> list) {
		System.out.println(list);
		
	}

	@Override
	protected <T> void saveJavaBean(T t) {
		System.out.println(t);
	}

}
