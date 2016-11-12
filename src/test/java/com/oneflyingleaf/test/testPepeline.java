package com.oneflyingleaf.test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.junit.Test;

import com.oneflyingleaf.core.page.impl.AbstractPage;
import com.oneflyingleaf.core.pipeline.impl.ConsolePipeline;
import com.oneflyingleaf.core.site.Site;

public class testPepeline {

	
	/**
	 * 测试爬虫运行
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	@Test
	public void testCeawlerRun() throws IOException, URISyntaxException{
		new Site("http://book.qidian.com/info/1003354631").addPage(new AbstractPage(){

			@Override
			public <T> T parse(Document document) {
				
				Map<String ,String > map = new HashMap<String,String>();	
				map.put("书名", document.select(".book-detail-wrap .book-info h1 em").text());
				map.put("作者", document.select(".book-detail-wrap .book-info h1 .writer").text());
				map.put("简介", document.select(".book-detail-wrap .book-info .intro").text());
				
				return (T) map;
			}
			
		}.addPipeline(new ConsolePipeline())).execute();
	}
}
