package com.javaguides.springboot.domains;

import java.util.*;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonIdentityInfo (
	generator = ObjectIdGenerators.PropertyGenerator.class,
	property = "timelineID"
)
@Entity
public class Timeline {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer timelineID;

    private String    startTime;
    private String    endTime;

    //set up one to many relationship with keypoints
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "timeline")
    private Set<Keypoints> keypointsList; 

    //setup one to one with event 
    @OneToOne(mappedBy = "timeline", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JsonBackReference(value="timelineRef")
    private Events event;

    public Timeline() {
    }

    public Timeline(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getTimelineID() {
        return timelineID;
    }

    public void setTimelineID(Integer timelineID) {
        this.timelineID = timelineID;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Set<Keypoints> getKeypoints(){
    	return this.keypointsList;
    }

    public void setKeypoints(Set<Keypoints> keypointsList) {
        this.keypointsList = keypointsList;
    }

    public void setEvent(Events event){
	    this.event = event; 
    }
    public Events getEvent(){
	    return this.event;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        
        sb.append("\"timelineID\": ").append(timelineID.toString());
        sb.append(", \"startTime\": \"").append(startTime).append("\"");
        sb.append(", \"endTime\": \"").append(endTime).append("\"}");
	
	return sb.toString();
    }
}
