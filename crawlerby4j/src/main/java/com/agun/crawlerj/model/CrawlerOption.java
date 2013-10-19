package com.agun.crawlerj.model;

import java.util.List;

public class CrawlerOption {
	private String workDir;
	private int maxDepth;
	private int maxPage;
	private int maxSleep;
	private int maxThread;
	
	private List<String> seedList;
	
	public String getWorkDir() {
		return workDir;
	}
	public void setWorkDir(String workDir) {
		this.workDir = workDir;
	}
	public int getMaxDepth() {
		return maxDepth;
	}
	public void setMaxDepth(int maxDepth) {
		this.maxDepth = maxDepth;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public List<String> getSeedList() {
		return seedList;
	}
	public void setSeedList(List<String> seedList) {
		this.seedList = seedList;
	}
	public int getMaxSleep() {
		return maxSleep;
	}
	public void setMaxSleep(int maxSleep) {
		this.maxSleep = maxSleep;
	}
	public int getMaxThread() {
		return maxThread;
	}
	public void setMaxThread(int maxThread) {
		this.maxThread = maxThread;
	}
	
}
