package com.javaguides.springboot.domains;

import java.util.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
public class Events{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Event_Id;

	private String name;
	private String date;

	//one to one relations
	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "location_id")
	@JsonManagedReference (value="locationRef")
	private Locations location;

	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "timeline_id")
	@JsonManagedReference (value="timelineRef")
	private Timeline timeline;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="customerID")
	@JsonBackReference(value="customerRef")
	private Customer customer;

	public void setEventId(Integer Event_Id){
		this.Event_Id = Event_Id; 
	}

	public Integer getEventId(){
		return this.Event_Id;
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

	public void setCustomer(Customer customer){
		this.customer = customer; 
	}

	public Customer getCustomer(){
		return this.customer;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{");

		sb.append("\"Event_ID\": ").append(Event_Id.toString());
		sb.append(", \"name\": \"").append(name).append("\"");
		sb.append(", \"date\": \"").append(date).append("\"}");
		sb.append(", \"location\": \"").append(location).append("\"}");
		sb.append(", \"timeline\": \"").append(timeline).append("\"}");

		return sb.toString();
	}
}
