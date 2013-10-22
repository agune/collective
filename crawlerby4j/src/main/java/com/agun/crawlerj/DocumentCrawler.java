package com.agun.crawlerj;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.agun.crawlerj.model.PageInfo;
import com.agun.crawlerj.model.SiteInfo;
import com.agun.crawlerj.persistent.PersistentDriver;
import com.agun.crawlerj.persistent.PersistentFactory;
import com.agun.crawlerj.util.UrlStringUtil;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class DocumentCrawler extends WebCrawler {

	
	
	
	
	
	
	private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|bmp|gif|jpe?g" + "|png|tiff?|mid|mp2|mp3|mp4"
            + "|wav|avi|mov|mpeg|ram|m4v|pdf" + "|rm|smil|wmv|swf|wma|zip|rar|gz))$");

	public boolean shouldVisit(WebURL url) {
        String href = url.getURL().toLowerCase();
        return !FILTERS.matcher(href).matches() && href.startsWith("http://sports.media.daum.net");
	}


	
	 @Override
     public void visit(Page page) {
		 int docid = page.getWebURL().getDocid();
		 String url = page.getWebURL().getURL();
		 int parentDocid = page.getWebURL().getParentDocid();

/**		 
		 System.out.println("Docid: " + docid);
		 System.out.println("URL: " + url);
		 System.out.println("Docid of parent page: " + parentDocid);
**/		 
		 
		 String domain  = UrlStringUtil.extractDomain(url); 
		 SiteInfo siteInfo = new SiteInfo();
		 siteInfo.setDomain(domain);
	
		 
		 if (page.getParseData() instanceof HtmlParseData) {
			 List<PageInfo> pageInfoList = new ArrayList<PageInfo>();
			 
			 HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
			 String text = htmlParseData.getText();
			 String html = htmlParseData.getHtml();
			 
			 
			 List<WebURL> links = htmlParseData.getOutgoingUrls();
			
			 PageInfo pageInfo = new PageInfo();
			 pageInfo.setUrl(url);
			 pageInfo.setText(text);
			 pageInfo.setHtml(html);
			 pageInfo.setSiteDomain(domain);
			 pageInfoList.add(pageInfo);
			 
			 System.out.println("Text length: " + text.length());
			 System.out.println("Html length: " + html.length());
			 System.out.println("Number of outgoing links: " + links.size());
		 
			 siteInfo.setPageInfoList(pageInfoList);
		 }
		
		 PersistentDriver persistentDriver = PersistentFactory.getPersistent();
		 persistentDriver.putSite(siteInfo); 
     }



	

	
}
