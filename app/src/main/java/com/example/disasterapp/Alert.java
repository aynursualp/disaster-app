package com.example.disasterapp;

public class Alert {
    private String title;
    private String description;
    private String urgency;
    private boolean isExpanded = false;

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public Alert(String title, String description, String urgency) {
        this.title = title;
        this.description = description;
        this.urgency = urgency;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return  description;
    }

    public String getUrgency() {
        return urgency;
    }

    public boolean isExpanded() {
        return isExpanded;
    }
}

