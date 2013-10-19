package com.agun.crawlerj;

import java.util.List;
import java.util.regex.Pattern;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class DocumentCrawler extends WebCrawler {

	private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|bmp|gif|jpe?g" + "|png|tiff?|mid|mp2|mp3|mp4"
            + "|wav|avi|mov|mpeg|ram|m4v|pdf" + "|rm|smil|wmv|swf|wma|zip|rar|gz))$");

	public boolean shouldVisit(WebURL url) {
        String href = url.getURL().toLowerCase();
        System.out.println("view =======================> " +  href);
        return !FILTERS.matcher(href).matches() && href.startsWith("http://news.naver.com");
	}


	
	 @Override
     public void visit(Page page) {
             int docid = page.getWebURL().getDocid();
             String url = page.getWebURL().getURL();
             int parentDocid = page.getWebURL().getParentDocid();

             System.out.println("Docid: " + docid);
             System.out.println("URL: " + url);
             System.out.println("Docid of parent page: " + parentDocid);

             if (page.getParseData() instanceof HtmlParseData) {
                     HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
                     String text = htmlParseData.getText();
                     String html = htmlParseData.getHtml();
                     List<WebURL> links = htmlParseData.getOutgoingUrls();
                     System.out.println("Text length: " + text.length());
                     System.out.println("Html length: " + html.length());
                     System.out.println("Number of outgoing links: " + links.size());
             }

             System.out.println("=============");
     }


	
}
