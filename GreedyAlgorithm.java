package com.company;

/**
 * This specific class represents a method of Solving the Room Assignment Problem.
 * <p> A Java program to implement greedy algorithm for solving the problem.</p>
 * <p>It resembles the method of coloring graphs in a greedy way. </p>
 * <p>First of all we "draw" and adjacent matrix where the nodes are the Events.</p>
 * <p>If the events start at the same time the [i][j]vertex is equal to 1, and if not the [i][j]vertex is equal to 0. </p>
 *  <p>We choose properly the Room for the events depending on the capacity</p>
 *  <p>The we do the following steps: </p>
 * <ol>
 *   <li>We assign a Room(color) for the first event.</li>
 *   <li>The remaining Rooms we assign to the remaining Events in a greedy way.</li>
 * </ol>
 */
public class GreedyAlgorithm extends Algorithm {

    /**
     *
     *
     * @param events the array of events
     * @param rooms the array of rooms
     */
    public GreedyAlgorithm(Event[] events, Room[] rooms) {
        events = events;
        rooms = rooms;

        int [][] matrice = new int[events.length][events.length];

        int result2[] = new int[rooms.length];

        for(int i = 0; i < events.length; i++) {

            for(int j = 0; j < events.length; j++){
                matrice[i][j] = -1;
                if(events[i].getStartTime() == events[j].getStartTime() && i!=j){
                    matrice[i][j] = 1;
                }
                else if(i==j)
                    matrice[i][j] = 1;
                else matrice[i][j] =0;
            }
        }

        for(int i = 0; i < events.length; i++) {
            for (int j = 0; j< events.length; j++ ) {
                System.out.format(matrice[i][j] + " ");
            }
            System.out.format("\n");
        }

        int result1[] = new int[events.length];
        boolean available[] = new boolean[result1.length];

        available[0] = true;
        available[1] = true;
        available[2] = true;
        available[3] = true;
        available[4] = true;

        for(int j=0;j<rooms.length;j++)
            if(events[0].getNumOfParticipants() > rooms[j].getCapacity())
                available[j] = false;
        for (int cr = 0; cr < rooms.length; cr++) {
            if (available[cr]){
                result1[0] = cr;
                break;
            }
        }

        for (int u = 1; u < events.length; u++){
            available[0] = true;
            available[1] = true;
            available[2] = true;
            available[3] = true;
            available[4] = true;
            for (int j = 0; j < events.length; j++) {
                if (matrice[u][j] == 1)  {
                    available[result1[j]] = false;
                }
            }
            for(int j=0;j<rooms.length;j++)
                if(events[u].getNumOfParticipants() > rooms[j].getCapacity())
                    available[j] = false;

                int cr;
                for (cr = 0; cr < rooms.length; cr++) {
                    if (available[cr])
                        break;
                }
                result1[u] = cr;
        }

        for (int j = 0; j < events.length; j++)
            System.out.println(events[j].getName() + " --->  "
                    + rooms[result1[j]].getName());

        System.out.println("Avem " + result1.length + " Eventimente.");
        System.out.println("Avem " + result2.length + " Camere.");
    }
}





