package com.javaguides.springboot.domains;

import java.util.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table (name="keypoint")
public class Keypoints {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer keypoint_ID;

    private String timeStart;
    private String timeEnd;
    private String description;
   
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "timeline_ID")
    private Timeline timeline; 

    public Keypoints() {
    }

    public Keypoints(Integer keypoint_ID, String timeStart, String timeEnd, String description) {
        this.keypoint_ID = keypoint_ID;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.description = description;
    }

    public Integer getKeypoint_ID() {
        return keypoint_ID;
    }

    public void setKeypoint_ID(Integer keypoint_ID) {
        this.keypoint_ID = keypoint_ID;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        
        sb.append(", \"timeStart\": \"").append(timeStart).append("\"");
        sb.append(", \"timeEnd\": \"").append(timeEnd).append("\"}");
        sb.append(", \"description\": \"").append(description).append("\"}");
        sb.append(", \"timelineID\": ").append(timeline.toString());

	return sb.toString();
    }
}
