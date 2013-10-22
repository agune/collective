package com.agun.crawlerj.persistent;

import java.util.Map;

import com.agun.crawlerj.model.PageInfo;
import com.agun.crawlerj.model.SiteInfo;

public interface PersistentDriver {
	public void init(Map<?, ?> obj); 
	public void putSite(SiteInfo siteInfo);
	public void putPage(PageInfo pageInfo);
	public void delSite(SiteInfo siteInfo);
	public void delPage(PageInfo pageInfo);
	public SiteInfo getSiteInfo(SiteInfo siteInfo);
	public PageInfo getPageInfo(PageInfo pageInfo);
}
