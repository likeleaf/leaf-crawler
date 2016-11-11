package com.oneflyingleaf.core.site;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.oneflyingleaf.core.html.Html;
import com.oneflyingleaf.core.page.Page;
import com.oneflyingleaf.core.util.ListUtils;


public class Site {
	
	private URI url = null;
	private HttpClient httpClient = null;
	private List<Page> pages = new LinkedList<Page>();
	private List<Cookie> cookies = null;
	
	public Site(URI url){
		this.url = url;
		
	}
	
	public Site(String url) throws URISyntaxException {
		this.url = new URI(url);
	} 

	
	/**
	 * 添加cookie
	 * @param cookie
	 * @return
	 */
	public Site addCookie(Cookie... cookie){
		return addCookie(ListUtils.variableParamToList(cookie));
	}
	
	/**
	 * 添加cookie
	 * @param cookie
	 * @return
	 */
	public Site addCookie(String key,String value){
		return addCookie(new BasicClientCookie(value, value));
	}
	
	/**
	 * 添加cookie
	 * @param cookie
	 * @return
	 */
	public Site addCookie(List<Cookie> cookie){
		this.cookies.addAll(cookie);
		return this;
	}
	
	/**
	 * 添加单页
	 * @param page 单页
	 * @return 添加页后的site
	 */
	public Site addPage(Page page){
		return addPage(page);
	}
	
	/**
	 * 添加若干页
	 * @param pages 可变
	 * @return 添加页后的site
	 */
	public Site addPages(Page... pages){
		return addPages(ListUtils.variableParamToList(pages));
	}
	
	/**
	 * 添加页
	 * @param pages 页的集合
	 * @return 添加页后的site
	 */
	public Site addPages(List<Page> pages){
		this.pages.addAll(pages);
		return this;
	}
	
	/**
	 * 删除页
	 * @param page 单页
	 * @return 删除后的site
	 */
	public Site removePage(Page page){
		return removePages(page);
	}
	
	/**
	 * 删除页
	 * @param pages 可变
	 * @return 删除后的site
	 */
	public Site removePages(Page... pages){
		return removePage(ListUtils.variableParamToList(pages));
	}

	/**
	 * 删除页
	 * @param pages list集合
	 * @return 删除后的site
	 */
	public Site removePage(List<Page> variableParamToList) {
		this.pages.removeAll(variableParamToList);
		return this;
	}
	
	/**
	 * 执行
	 * @throws IOException 
	 */
	public void execute() throws IOException{
		if(ListUtils.isEmpty(this.pages)){
			throw new NullPointerException("未添加Page");
		}
		Document document =  Jsoup.connect(url.toString()).cookies(ListUtils.cookieListToMap(this.cookies)).get();
		
		/*HttpGet httpGet = new HttpGet(this.url);
		
		httpClient.execute(httpGet);*/
		
		
		for(Page page : this.pages){
			page.execute(new Html().setDocument(document)).save();
		}
	}
	
}
