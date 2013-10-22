package com.agun.crawlerj.model;

import java.util.Date;
import java.util.List;

public class SiteInfo {
	private String domain;
	private String parentDomain;
	private Date lastSeek;
	List<PageInfo> pageInfoList;
	
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getParentDomain() {
		return parentDomain;
	}
	public void setParentDomain(String parentDomain) {
		this.parentDomain = parentDomain;
	}
	public Date getLastSeek() {
		return lastSeek;
	}
	public void setLastSeek(Date lastSeek) {
		this.lastSeek = lastSeek;
	}
	public List<PageInfo> getPageInfoList() {
		return pageInfoList;
	}
	public void setPageInfoList(List<PageInfo> pageInfoList) {
		this.pageInfoList = pageInfoList;
	}
}
