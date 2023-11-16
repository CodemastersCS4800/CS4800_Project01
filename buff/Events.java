package com.javaguides.springboot.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;


@Entity 
public class Events{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer EventId;

	private String name;
	private String date;

	//one to one relations
	private Locations location;
	private Timeline timeline;

	@Lob
	private String GuestList;

	// many to one relationship with customer 

	public void setID(Integer EventId){
		this.EventId = EventId; 
	}

	public Integer getID(){
		return this.EventId;
	}

	public void setName(String name){
		this.name= name; 
	}

	public String getName(){
		return this.name;
	}
	
	public void setDate(String date){
		this.date = date; 
	}

	public String getDate(){
		return this.date;
	}
	
	public void setLocation(Locations location){
		this.location = location; 
	}

	public Locations getLocation(){
		return this.location;
	}
	
	public void setTimeline(Timeline timeline){
		this.timeline = timeline; 
	}

	public Timeline getTimeline(){
		return this.timeline;
	}

	public void setGuestList(String GuestList){
		this.GuestList = GuestList; 
	}

	public String getGuestList(){
		return this.GuestList;
	}
}
