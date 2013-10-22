package com.agun.crawlerj.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlStringUtil {

	private static Pattern urlPattern = Pattern.compile("^(https?):\\/\\/([^:\\/\\s]+)(:([^\\/]*))?((\\/[^\\s/\\/]+)*)?\\/([^#\\s\\?]*)(\\?([^#\\s]*))?(#(\\w*))?$");
	
	public static String extractDomain(String url){
		Matcher mc = urlPattern.matcher(url);
		if(mc.matches() && mc.groupCount() > 2){
			return mc.group(2);
		}
		return null;
	}
}
