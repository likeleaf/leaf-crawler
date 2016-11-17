package com.oneflyingleaf.core.page;

import org.jsoup.nodes.Document;

import com.oneflyingleaf.core.html.Html;
import com.oneflyingleaf.core.pipeline.Pipeline;

public interface Page {
	
	/**
	 * 执行页面处理的内容
	 */
	void execute(Html html);
	
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
	 * 解析需要保存的内容
	 * @param documnt
	 * @return 最终需要返回的内容
	 */
	<T> T parse(Document documnt);
	
	
	/**
	 * 页面匹配的url正则
	 * @param rege
	 * @return
	 */
	boolean matchReg(String url);
	
	/**
	 * 添加正则
	 * @param reg
	 * @return
	 */
	Page addReg(String reg);
}
