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

    public Timeline(String timeLineID, int startTime, int endTime) {
        this.timeLineID = timeLineID;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getTimeLineID() {
        return timeLineID;
    }

    public void setTimeLineID(String timeLineID) {
        this.timeLineID = timeLineID;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
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
