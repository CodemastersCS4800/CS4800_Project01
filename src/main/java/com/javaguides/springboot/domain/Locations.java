package com.javaguides.springboot.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity 
public class Locations{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String address;
	private String size;
	private Integer maxCapacity;

	// setup one to one relationship with event


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
}
