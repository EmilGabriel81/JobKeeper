package com.jobkeeper.controller;

import java.util.EventObject;

public class FormEvent extends EventObject {

//	private String itemName;
//	private String itemBrand;
//	private double itemSize;
//	private double itemPrice;
//	private int itemQuantity;
//	private String itemDescription;
//	private boolean itemOnSale;
//	private boolean itemOnStock;

	private String name;
	private String position;
	private String location;
	private String date;
	private static int counter = 0;
	private int id;
	private String notes = "";
	
	public FormEvent(Object source) {
		super(source);

	}

	public FormEvent(Object source, String name, String position, String location, String notes){
		super(source);
		
		this.name = name;
		this.position = position;
		this.location = location;
		//this.date = date;
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

	public String getDate() {
		return date;
	}

	public String getNotes() {
		return notes;
	}

	
	
	
	

}
