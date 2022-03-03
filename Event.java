package com.company;

// Class for Events
// Each event has a name, a number of participants (its size), a start time and an end time.

public class Event {
    private String name;
    private int numOfParticipants;
    private int startTime;
    private int endTime;

    public Event(String name, int numOfParticipants, int startTime, int endTime) {
        this.name = name;
        this.numOfParticipants = numOfParticipants;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Event(){};

    public String getName() {
        return name;
    }

    public int getNumOfParticipants() {
        return numOfParticipants;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumOfParticipants(int numOfParticipants) {
        this.numOfParticipants = numOfParticipants;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Eveniment{" +
                "nume = '" + name + '\'' +
                ", numar de participanti = " + numOfParticipants +
                ", ora start = " + startTime +
                ", ora sfarsit = " + endTime +
                '}';
    }


}