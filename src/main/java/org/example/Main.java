package org.example;

import org.example.Enitity.Building;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Building building = new Building();
        while(true) {
            Scanner scan = new Scanner(System.in);
            String token = scan.nextLine();
            String[] command = token.split(" ");
            if(command[0].equals("ADD") && command[1].equals("BUILDING")){
                building.addBuilding();
            }
            else if(command[0].equals("ADD") && command[1].equals("FLOOR")){
                String buildingName = command[2];
                int noOfFloor = Integer.parseInt(command[3]);
                building.addFloor(noOfFloor, buildingName);
            }else if(command[0].equals("ADD") && command[1].equals("CONFROOM")){
                String confRoom = command[2];
                int floorNum = Integer.parseInt(command[3]);
                String buildingName = command[4];
                building.addConferenceRoom(confRoom, floorNum, buildingName);
            }
            else if(command[0].equals("BOOK")){
                int from = Integer.parseInt(String.valueOf(command[1].charAt(0)));
                int to = Integer.parseInt(String.valueOf(command[1].charAt(2)));
                String buildingName = command[2];
                int floorNum = Integer.parseInt(command[3]);
                String confRoom = command[4];
                if(to > 25 || to < 0 || from < 0 || from > 25){
                    System.out.println("Time slot is not correct");
                }
                else if(to == from){
                    System.out.println("Time slot is not correct");
                }
                else{
                    building.bookConferenceRoom(from, to, buildingName, floorNum, confRoom);
                }
            }
            else if(command[0].equals("LIST") && command[1].equals("ROOM")){
                building.listAllConferenceRoom();
            } else if (command[0].equals("EXIT")) {
                break;
            }

        }
    }
}