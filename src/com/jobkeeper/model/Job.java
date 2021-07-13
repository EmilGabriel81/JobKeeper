package com.jobkeeper.model;

public class Job {
	
	private String name;
	private String position;
	private String location;
	private String date;
	private static int counter = 0;
	private int id;
	private String notes = "";
	

	public Job(){
		
	}
	
	public Job(String name, String position, String location, String date) {
		
		this.id = ++counter;
		this.name = name;
		this.position = position;
		this.location = location;
		this.date = date;
		
	}

	public Job(int id,String name, String position, String location, String date, String notes) {
		this(name, position, location, date);
		
		this.id = id;
		this.notes = notes;
		
	}
	
	public String getName() {
		return name;
	}

	public String getPosition() {
		return position;
	}

	public String getLocation() {
		return location;
	}

	public int getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public String getNotes() {
		return notes;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Job.counter = counter;
	}

	@Override
	public String toString() {
		return "Job [name = " + name + ", position = " + position + ", location = " + location + ", date = " + date + ", id = "
				+ id + ", notes = " + notes + "]";
	}
	
	
	
}
