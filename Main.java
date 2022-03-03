package com.company;

import static com.company.Type.LECTURE_HALL;
import static com.company.Type.LABORATORY;

public class Main {

    public static void main(String[] args) {
        //Events
        Event C1 = new Event("C1", 100, 8, 10);
        Event C2 = new Event("C2", 100, 10, 12);
        Event L1 = new Event("L1", 30, 8, 10);
        Event L2 = new Event("L2",10, 8, 10);
        Event L3 = new Event("L3", 30, 10, 12);

        //Rooms
        Room R1 = new Room("401", LABORATORY, 30 );
        Room R2 = new Room("403", LABORATORY, 30 );
        Room R3 = new Room("405", LABORATORY, 30 );
        Room R4 = new Room("309", LECTURE_HALL, 100 );

        System.out.println(C1);
        System.out.println(C2);
        System.out.println(L1);
        System.out.println(R1);

        if(L1.getNumOfParticipants() > 30) {
            System.out.println( L1.getName() + "->" + R4.getName());
        } else if (L1.getNumOfParticipants() <= 30){
            System.out.println( L1.getName() + "->" + R2.getName());
        }
    }


}
