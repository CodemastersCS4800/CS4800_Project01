package com.javaguides.springboot.domains;

import java.util.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;

@Entity
public class Timeline {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer timelineID;

    private String    startTime;
    private String    endTime;

    //set up one to many relationship with keypoints
    @OneToMany(mappedBy = "timeline")
    private Set<Keypoints> KeypointsList; 

    //setup one to one with event 
    

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        
        sb.append("\"timelineID\": ").append(timelineID.toString());
        sb.append(", \"startTime\": \"").append(startTime).append("\"");
        sb.append(", \"endTime\": \"").append(endTime).append("\"}");

	return sb.toString();
    }
}
