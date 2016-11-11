package com.oneflyingleaf.core.page;

import com.oneflyingleaf.core.html.Html;
import com.oneflyingleaf.core.pipeline.Pipeline;

public interface Page {
	
	/**
	 * 执行页面处理的内容
	 */
	Page execute(Html html);
	
	/**
	 * 添加管道
	 * @param Pipeline
	 */
	Page addPipeline(Pipeline... Pipeline);
	
	/**
	 * 移除管道
	 * @param Pipeline
	 */
	Page removePipeline(Pipeline... Pipeline);
	
	/**
	 * 保存信息
	 */
	Page save();
	
}
