package com.company;
/**
 * The Events is a class for all the events that we use in the problem.
 * <p>Each Event has:</p>
 *  <ul>
 * <li>a name
 * <li>a number of participants (its size)
 * <li>a start time
 * <li>an end time
 * </ul>
 *
 * @author Stratan Corina
 */

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

    /**
     *Indicates whether some other Event is "equal to" this one
     *
     * @param o some other object
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return numOfParticipants == event.numOfParticipants && startTime == event.startTime && endTime == event.endTime && name.equals(event.name);
    }

    /**
     * @return the name of the Event
     */
    public String getName() {
        return name;
    }

    /**
     * @return the number of the participants
     */
    public int getNumOfParticipants() {
        return numOfParticipants;
    }

    /**
     * @return the start time
     */
    public int getStartTime() {
        return startTime;
    }

    /**
     *
     * @return the end time
     */
    public int getEndTime() {
        return endTime;
    }

    /**
     *
     * @param name name of the room
     */
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
        return name ;
    }


}
