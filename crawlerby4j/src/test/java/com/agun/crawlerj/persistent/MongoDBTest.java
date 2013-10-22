package com.agun.crawlerj.persistent;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.agun.crawlerj.model.PageInfo;
import com.agun.crawlerj.model.SiteInfo;

public class MongoDBTest {

	@Test
	public void putSiteTest() {
		Map<String, String> initMap =  new Hashtable<String, String>();
		initMap.put("host", "127.0.0.1");
		initMap.put("db", "dataTest");
		MongoDB mongoDB = MongoDB.getInstance();
		mongoDB.init(initMap);
		SiteInfo siteInfo = new SiteInfo();
		siteInfo.setDomain("sports.news.naver.com");
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setSiteDomain("sports.news.naver.com");
		pageInfo.setHtml("html test");
		pageInfo.setText("안녕하세요 굿잡 입니다. modify ");
		List<PageInfo> pageInfoList = new ArrayList<PageInfo>();
		pageInfoList.add(pageInfo);
		siteInfo.setPageInfoList(pageInfoList);
		mongoDB.putSite(siteInfo);
	}

	@Test
	public void getSiteTest() {
		Map<String, String> initMap =  new Hashtable<String, String>();
		initMap.put("host", "127.0.0.1");
		initMap.put("db", "dataTest");
		MongoDB mongoDB = MongoDB.getInstance();
		mongoDB.init(initMap);
		SiteInfo siteInfo = new SiteInfo();
		siteInfo.setDomain("sports.news.naver.com");
		SiteInfo result = mongoDB.getSiteInfo(siteInfo);
		assertNotNull("not file site info", result);
	}
	
	
	
}
