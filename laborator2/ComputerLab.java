package com.company;

/**
 * This ComputerLab class extends the Room class, representing a specific Room Type.
 * <p> Every Computer Lab has: </p>
 *   <ul>
 *  <li>a name
 *  <li>a capacity
 *  </ul>
 * <p> This class also adds new information about the ComputerLab Room which is what operating system the computers have. </p>
 *
 * @author Stratan Corina
 */

public class ComputerLab extends Room{

    String operatingSystem;

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    /**
     * Explicit value constructor for Computer Labs.(<code>String, int, String </code>)
     *
     * @param name represents the name of the Computer Lab
     * @param capacity represents the maximum capacity of the Computer Lab
     * @param operatingSystem indicate the operating system of the room's computers
     */

    public ComputerLab(String name, int capacity, String operatingSystem) {
        super(name, capacity);
        this.operatingSystem = operatingSystem;
    }



}
