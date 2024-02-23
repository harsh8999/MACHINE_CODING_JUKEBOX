package com.example.demo.entities;

public enum Status {
    PLAYING("playing"), STOPPED("stopped"), PAUSED("paused");

    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
