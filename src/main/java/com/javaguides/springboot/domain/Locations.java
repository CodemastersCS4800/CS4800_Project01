package com.javaguides.springboot.domains;

import java.util.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity 
public class Locations{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String address;
	private String size;
	private Integer maxCapacity;

	// setup one to one relationship with event
	@OneToOne(mappedBy = "location", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonBackReference(value="locationRef")
	private Events event;

	public Locations(){
	}	

	public void setID(Integer id){
		this.id = id; 
	}

	public Integer getID(){
		return this.id;
	}

	public void setAddress(String addr){
		this.address = addr; 
	}
	public String getAddress(){
		return this.address;
	}

	public void setSize(String size){
		this.size = size; 
	}
	public String getSize(){
		return this.size; 	
	}

	public void setMaxCapacity(Integer cap){
		this.maxCapacity = cap; 
	}
	public Integer getMaxCapacity(){
		return this.maxCapacity;
	}

	public void setEvent(Events event){
		this.event = event; 
	}
	public Events getEvent(){
		return this.event;
	}
}
