package com.agun.crawlerj;

import java.util.List;

import com.agun.crawlerj.model.CrawlerOption;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class AbstractCrawler implements clawlerj {

	public void run(CrawlerOption crawlerOption) {
		
		List<String> seedList = crawlerOption.getSeedList();
		
		if(seedList == null || seedList.size() == 0)
			return;
		
		CrawlConfig config = new CrawlConfig();
		
		config.setCrawlStorageFolder(crawlerOption.getWorkDir());
		
		if(crawlerOption.getMaxSleep() == 0)
			config.setPolitenessDelay(1000);
		else
			config.setPolitenessDelay(crawlerOption.getMaxSleep());
				
		config.setMaxDepthOfCrawling(crawlerOption.getMaxDepth());
		config.setMaxPagesToFetch(crawlerOption.getMaxPage());
		config.setResumableCrawling(false);
		
		PageFetcher pageFetcher = new PageFetcher(config);
		RobotstxtConfig robotstxConfig = new RobotstxtConfig();
		robotstxConfig.setEnabled(false);
		
		RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxConfig, pageFetcher);
		CrawlController controller;
		try {
			controller = new CrawlController(config, pageFetcher, robotstxtServer);
			for(String seed :  seedList){
				controller.addSeed(seed);
			}
			controller.start(DocumentCrawler.class, crawlerOption.getMaxThread());
         } catch (Exception e) {
        	 e.getStackTrace();
         }
	}
}
