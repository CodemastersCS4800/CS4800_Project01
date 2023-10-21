package com.javaguides.springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Timeline {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer timeLineID;

    private String    startTime;
    private String    endTime;

    public Timeline(Integer timeLineID, String startTime, String endTime) {
        this.timeLineID = timeLineID;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getTimeLineID() {
        return timeLineID;
    }

    public void setTimeLineID(Integer timeLineID) {
        this.timeLineID = timeLineID;
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
        return "Timeline{" +
                "timeLineID='" + timeLineID + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
