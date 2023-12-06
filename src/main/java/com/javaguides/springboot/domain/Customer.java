package com.javaguides.springboot.domains;

import java.util.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer  CustomerId;

    private String name;
    private String email;
    private String password;

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy = "customer")
    @JsonManagedReference(value="customerRef")
    private Set<Events> EventsList; 

    //constructor
    public Customer(){
    }

    //Everthing Constructor
    public Customer(long id, String name,String email){
        this.name = name;
        this.CustomerId = CustomerId;
        this.email = email;

    }
    //Constructor w/o id
    public Customer(String name, String email){
        this.name = name;
        this.email = email;

    }

    public long getId() {
        return CustomerId;
    }
    public void setId(Integer id) {
        this.CustomerId = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Events> getEvents(){
    	return this.EventsList;
    }
    public void setEvents(Set<Events> eventsList){
    	this.EventsList = eventsList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        
        sb.append("\"CutomerID\": ").append(CustomerId.toString());
        sb.append(", \"Name\": \"").append(name).append("\"");
        sb.append(", \"email\": \"").append(email).append("\"}");
	
	return sb.toString();
    }
}
