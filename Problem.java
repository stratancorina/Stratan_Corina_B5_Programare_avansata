package com.company;
import java.util.Arrays;

/**
 * The Problem class prints for the client the instance of the problem, more precisely the rooms and the events.
 *
 * @author Stratan Corina
 */
public class Problem {
    private Event[] events;
    private Room[] rooms;

    /**
     * Explicit value constructor for Problem (<code>Event, Room </code>)
     *
     * @param events the array with Events
     * @param rooms the array with Rooms.
     */
    public Problem(Event[] events, Room[] rooms) {
        this.events = events;
        this.rooms = rooms;
    }

    /**
     * @return the events
     */
    public Event[] getEvents() {
        return events;
    }
    /**
     * @return the rooms
     */
    public Room[] getRooms() {
        return rooms;
    }

    /**
     * Sets the array of Events that we will use
     * @param events is an array with Events
     */
    public void setEvents(Event[] events) {
        events = events;
    }

    public void setRooms(Room[] rooms) {
        rooms = rooms;
    }

    /**
     * @return a string representation of the instance of the problem
     */
    @Override
    public String toString() {
        return "Problem: " + "\n" +
                "Events: " + Arrays.toString(events) + "; \n" +
                "Rooms: " + Arrays.toString(rooms) + ".";
    }


}
