package com.agun.crawlerj.model;

import java.util.Date;
import java.util.List;

public class PageInfo {

	private String siteDomain;
	private String url;
	private String html;
	private String text;
	private Date seekDate;
	private List<String> linkUrlList;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getSiteDomain() {
		return siteDomain;
	}
	public void setSiteDomain(String siteDomain) {
		this.siteDomain = siteDomain;
	}
	public Date getSeekDate() {
		return seekDate;
	}
	public void setSeekDate(Date seekDate) {
		this.seekDate = seekDate;
	}
	public List<String> getLinkUrlList() {
		return linkUrlList;
	}
	public void setLinkUrlList(List<String> linkUrlList) {
		this.linkUrlList = linkUrlList;
	}
}
