package org.example;

import org.example.Enitity.Building;
import org.example.Enitity.ConferenceRoom;
import org.example.Enitity.Floor;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Building building = new Building();
        building.addBuilding();
        building.addBuilding();
        building.addFloor(2, 1);
        building.addFloor(2, 2);
        building.addConferenceRoom("c1", 1, "b1" );
        building.addConferenceRoom("c5", 2, "b2" );
        building.addConferenceRoom("c3", 2, "b1" );
        building.addConferenceRoom("c3", 2, "b1" );
        building.listAllConferenceRoom();
        building.bookConferenceRoom(1,5, "b1",2 , "c3");
        building.bookConferenceRoom(7,10, "b1",2 , "c3");
        building.bookConferenceRoom(0,24, "b1",1 , "c1");
        building.listAllBookedConferenceRoom();
        building.listAllConferenceRoom();
        building.cancelBookedConferenceRoom(0,24, "b1",1 , "c1");
        building.cancelBookedConferenceRoom(0,24, "b1",1 , "c1");
        building.listAllConferenceRoom();
    }
}