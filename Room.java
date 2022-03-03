package com.company;

//Class for Rooms
//Each room has a name, a type and a capacity.
public class Room {
    private String name;
    private Type type;
    private int capacity;

    public Room(String name, Type type, int capacity) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }
    public Type getType() {
        return type;
    }
    public int getCapacity() {
        return capacity;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Sala {" +
                "nume = '" + name + '\'' +
                ", tip = " + type +
                ", capacitate = " + capacity +
                '}';
    }

}