package com.javaguides.springboot.model;

public class Keypoints {

    private String keypoint_ID;
    private String timeStart;
    private String timeEnd;
    private String description;


    public Keypoints() {
    }

    public Keypoints(String keypoint_ID, String timeStart, String timeEnd, String description) {
        this.keypoint_ID = keypoint_ID;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.description = description;
    }

    public String getKeypoint_ID() {
        return keypoint_ID;
    }

    public void setKeypoint_ID(String keypoint_ID) {
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

    @Override
    public String toString() {
        return "Keypoints{" +
                "keypoint_ID='" + keypoint_ID + '\'' +
                ", timeStart='" + timeStart + '\'' +
                ", timeEnd='" + timeEnd + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
