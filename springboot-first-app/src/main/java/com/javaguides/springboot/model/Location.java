package com.javaguides.springboot.model;

public class Location {
    private String locationID;
    private int locationAddress;
    private int locationSize;
    private int maxCapacity;


    public Location() {
    }

    public Location(String locationID, int locationAddress, int locationSize, int maxCapacity) {
        this.locationID = locationID;
        this.locationAddress = locationAddress;
        this.locationSize = locationSize;
        this.maxCapacity = maxCapacity;
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public int getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(int locationAddress) {
        this.locationAddress = locationAddress;
    }

    public int getLocationSize() {
        return locationSize;
    }

    public void setLocationSize(int locationSize) {
        this.locationSize = locationSize;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationID='" + locationID + '\'' +
                ", locationAddress=" + locationAddress +
                ", locationSize=" + locationSize +
                ", maxCapacity=" + maxCapacity +
                '}';
    }
}
