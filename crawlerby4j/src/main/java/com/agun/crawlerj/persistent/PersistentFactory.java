package com.agun.crawlerj.persistent;

import java.util.Hashtable;
import java.util.Map;

public class PersistentFactory {
	private static MongoDB mongoDB = null;
	
	public static PersistentDriver getPersistent(){
		if(mongoDB == null){
			mongoDB = MongoDB.getInstance();
			Map<String, String> initMap = new Hashtable<String, String>();
			initMap.put("host", "127.0.0.1");
			initMap.put("db", "dataTest");
			mongoDB.init(initMap);
		}
		return mongoDB;
	}
	
}
