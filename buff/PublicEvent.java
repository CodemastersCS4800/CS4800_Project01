package com.javaguides.springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PublicEvent {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer numberOfAttendants;

    private int date;
    private String data;
    private String eventID;
    private String venueLocation;
    private String guestListPath;
    private String timeLineID;
    private String finalFilePath;

    //Everything Constructor
    public PublicEvent(int numberOfAttendants, int date, long data, String eventID, String venueLocation, String guestListPath, String timeLineID, String finalFilePath) {
        this.numberOfAttendants = numberOfAttendants;
        this.date = date;
        this.data = data;
        this.eventID = eventID;
        this.venueLocation = venueLocation;
        this.guestListPath = guestListPath;
        this.timeLineID = timeLineID;
        this.finalFilePath = finalFilePath;
    }

    public int getNumberOfAttendants() {
        return numberOfAttendants;
    }

    public void setNumberOfAttendants(int numberOfAttendants) {
        this.numberOfAttendants = numberOfAttendants;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getVenueLocation() {
        return venueLocation;
    }

    public void setVenueLocation(String venueLocation) {
        this.venueLocation = venueLocation;
    }

    public String getGuestListPath() {
        return guestListPath;
    }

    public void setGuestListPath(String guestListPath) {
        this.guestListPath = guestListPath;
    }

    public String getTimeLineID() {
        return timeLineID;
    }

    public void setTimeLineID(String timeLineID) {
        this.timeLineID = timeLineID;
    }

    public String getFinalFilePath() {
        return finalFilePath;
    }

    public void setFinalFilePath(String finalFilePath) {
        this.finalFilePath = finalFilePath;
    }

    @Override
    public String toString() {
        return "PublicEvent{" +
                "numberOfAttendants=" + numberOfAttendants +
                ", date=" + date +
                ", data=" + data +
                ", eventID='" + eventID + '\'' +
                ", venueLocation='" + venueLocation + '\'' +
                ", guestListPath='" + guestListPath + '\'' +
                ", timeLineID='" + timeLineID + '\'' +
                ", finalFilePath='" + finalFilePath + '\'' +
                '}';
    }
}
