package com.jobkeeper.model;

import java.util.ArrayList;
import java.util.List;

public class Database {
	
	private List<Job> jobList;
	
	public Database() {
	
		jobList = new ArrayList<Job>();
		
	}
	
	public void addJob(Job job) {
		jobList.add(job);
	}

	public List<Job> getJobs(){
		return jobList;
	}
	
	
	
}
