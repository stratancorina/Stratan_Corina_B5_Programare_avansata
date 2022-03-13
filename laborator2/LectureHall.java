package com.company;

/**
 * This LectureHall class extends the Room class representing a specific Room Type.
 *  <p> Every Lecture Hall has: </p>
 * <ul>
 * <li>a name
 * <li>a capacity
 * </ul>
 *
 * <p> inheriting the name and capacity properties.</p>
 * <p> This class also adds new information about the LectureHall Room. </p>
 *
 * @author Stratan Corina
 */
public class LectureHall extends Room {

    private boolean hasAVideoProjector;

    /**
     * Explicit value constructor for Lecture Hall.(<code>String, int, boolean </code>)
     *
     * @param name represents the name of the Computer Lab
     * @param capacity represents the maximum capacity of the Computer Lab
     * @param hasAVideoProjector shows this room as or not a Video projector
     */
    public LectureHall(String name, int capacity, boolean hasAVideoProjector) {
        super(name, capacity);
        this.hasAVideoProjector = hasAVideoProjector;
    }

    public boolean isHasAVideoProjector() {
        return hasAVideoProjector;
    }

    public void setHasAVideoProjector(boolean hasAVideoProjector) {
        this.hasAVideoProjector = hasAVideoProjector;
    }

    public String toString() {
        return super.toString() ;
    }

}
