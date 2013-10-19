package com.agun.crawlerj;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.agun.crawlerj.model.CrawlerOption;

public class AbstractCrawlerTest {

	@Ignore
	@Test
	public void runTest() {
	
		List<String> seedList = new ArrayList<String>();
		seedList.add("http://your test url");
		
		CrawlerOption crawlerOption = new CrawlerOption();
		crawlerOption.setMaxPage(1);
		crawlerOption.setMaxDepth(1);
		crawlerOption.setMaxSleep(1000);
		crawlerOption.setMaxThread(1);
		crawlerOption.setWorkDir("/Users/pdc222/data");
		crawlerOption.setSeedList(seedList);
		AbstractCrawler abstractCrawler = new AbstractCrawler();
		abstractCrawler.run(crawlerOption);
	
	}
	
	

}
