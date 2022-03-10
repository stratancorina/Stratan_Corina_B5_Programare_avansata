package com.company;

/**
 * Main class solves the  Room Assignment Problem depending on certain conditions.
 *
 * @author Stratan Corina
 * @see Room
 * @see Event
 */
public class Main {

    /**
     * This is the main() method for the driver program.
     *
     * @param args stores the incoming command line arguments for the program.
     */
    public static void main(String[] args) {

        Event[] events = new Event[5];
        int index = 0;
        events [index++] = new Event("C1", 100, 8, 10);
        events [index++] = new Event("C2", 100, 10, 12);
        events [index++]= new Event("L1", 30, 8, 10);
        events [index++]= new Event("L2",10, 8, 10);
        events [index++]= new Event("L3", 30, 10, 12);

        Room[] rooms = new Room[4];
        rooms [0] = new ComputerLab("401",30 , "Linux");
        rooms [1]= new ComputerLab("403", 30 , "Windows");
        rooms [2] = new LectureHall("405", 30, true);
        rooms [3] = new LectureHall("309", 100, false );

        Problem pb = new Problem(events,rooms);
        System.out.println(pb);
        Algorithm greedy = new GreedyAlgorithm(events,rooms);
        //Solution sol = greedy.solve();


    }
}
