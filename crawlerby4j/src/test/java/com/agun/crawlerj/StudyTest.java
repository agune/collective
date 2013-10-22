package com.agun.crawlerj;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class StudyTest {

	@Test
	public void urlPatternTest() {

		String testUrl = "http://sports.news.naver.com/sports/index.nhn?category=worldfootball";
		
		Pattern urlPattern = Pattern.compile("^(https?):\\/\\/([^:\\/\\s]+)(:([^\\/]*))?((\\/[^\\s/\\/]+)*)?\\/([^#\\s\\?]*)(\\?([^#\\s]*))?(#(\\w*))?$");
		Matcher mc = urlPattern.matcher(testUrl);
	
		if(mc.matches()){
			for(int i=0; i<=mc.groupCount(); i++){
				System.out.println(i + "===>     " + mc.group(i));
			}
		}
	
	}

}
