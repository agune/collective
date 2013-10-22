package com.agun.crawlerj.persistent;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.agun.crawlerj.model.PageInfo;
import com.agun.crawlerj.model.SiteInfo;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoDB implements PersistentDriver {

	private static MongoDB mongoDB = new MongoDB();
	private MongoClient mongoClinet = null;
	private DB db = null;

	private MongoDB(){};

	public static MongoDB getInstance(){
		return mongoDB;
	}
	
	public void putSite(SiteInfo siteInfo) {
		if(vaildDB() == false)
			return;
		
		if(getSiteInfo(siteInfo) == null){
			DBCollection dbCollection = db.getCollection(SiteInfo.class.getSimpleName());
			BasicDBObject doc = new BasicDBObject();
			doc.append("domain", siteInfo.getDomain());
			doc.append("seekDate", new Date());
			dbCollection.insert(doc);
		}
		DBCollection dbCollection = db.getCollection(PageInfo.class.getSimpleName());
		List<PageInfo> pageInfoList = siteInfo.getPageInfoList();
		
		if(pageInfoList == null)
			return;
		
		for(PageInfo pageInfo : pageInfoList){
			BasicDBObject doc = new BasicDBObject();
			doc.append("domain", siteInfo.getDomain());
			doc.append("text", pageInfo.getText());
			doc.append("html", pageInfo.getHtml());
			doc.append("url", pageInfo.getUrl());
			doc.append("seekDate", new Date());
		
			if(getPageInfo(pageInfo) != null){
				BasicDBObject query = new BasicDBObject();
				query.append("url", pageInfo.getUrl());
				dbCollection.findAndModify(query, doc);
			}else{
				dbCollection.insert(doc);
			}
		}
	}
	

	public void putPage(PageInfo pageInfo) {
		if(vaildDB() == false)
			return;

	}

	public void delSite(SiteInfo siteInfo) {
		if(vaildDB() == false)
			return;

	}

	public void delPage(PageInfo pageInfo) {
		if(vaildDB() == false)
			return;

	}
	
	public void init(Map<?, ?> initMap) {
		try {
			mongoClinet = new MongoClient((String) initMap.get("host"));
			db = mongoClinet.getDB((String)initMap.get("db"));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	private boolean vaildDB(){
		if(mongoClinet == null)
			return false;		
		return true;
	}

	public SiteInfo getSiteInfo(SiteInfo siteInfo) {
		DBCollection dbCollection = db.getCollection(SiteInfo.class.getSimpleName());
		BasicDBObject doc = new BasicDBObject();
		doc.append("domain", siteInfo.getDomain());
		DBCursor cursor = dbCollection.find(doc);
		try{
			SiteInfo resultSiteInfo = new SiteInfo();
			while(cursor.hasNext()){
				DBObject dbObject = cursor.next();
				resultSiteInfo.setDomain((String)dbObject.get("domain"));
				resultSiteInfo.setLastSeek((Date)dbObject.get("seekDate"));
				return resultSiteInfo;
			}
		}finally{
			if(cursor != null)
				cursor.close();
		}
		return null;
	}

	public PageInfo getPageInfo(PageInfo pageInfo) {
		DBCollection dbCollection = db.getCollection(PageInfo.class.getSimpleName());
		BasicDBObject doc = new BasicDBObject();
		doc.append("url", pageInfo.getUrl());
		DBCursor cursor = dbCollection.find(doc);
		try{
			PageInfo resultPageInfo = new PageInfo();
			while(cursor.hasNext()){
				DBObject dbObject = cursor.next();
				resultPageInfo.setSiteDomain((String)dbObject.get("domain"));
				resultPageInfo.setSeekDate((Date)dbObject.get("seekDate"));
				resultPageInfo.setHtml((String)dbObject.get("html"));
				resultPageInfo.setText((String)dbObject.get("text"));
				resultPageInfo.setUrl((String)dbObject.get("url"));
				return resultPageInfo;
			}
		}finally{
			if(cursor != null)
				cursor.close();
		}
		return null;	
	}

}
