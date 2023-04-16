package org.example.Enitity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Building {
    ArrayList<ArrayList<ConferenceRoom>> building;
    HashMap<Integer, ArrayList<ArrayList<ConferenceRoom>>> space;
    int buildingNumber;

    public Building() {
        this.space = new HashMap<Integer, ArrayList<ArrayList<ConferenceRoom>>>();
    }

    public void addBuilding(){
        building = new ArrayList<ArrayList<ConferenceRoom>>();
        space.put(buildingNumber, building);
        System.out.println("Added building b"+ (buildingNumber + 1) +" into the system");
        buildingNumber++;
    }

    public void addFloor(int numberOfFloor, int buildingNum){
        building = space.get(buildingNum - 1);
        for(int floor = 0; floor < numberOfFloor; floor++){
            building.add(new ArrayList<ConferenceRoom>());
        }
        System.out.println("Added floor " + numberOfFloor +" in building b" + buildingNum);
    }

    public void addConferenceRoom(String roomNo, int floorNum, String buildingNum){
        int bn = Integer.parseInt(String.valueOf(buildingNum.charAt(1)));
        int len = space.size();
        if(len < bn - 1){
            System.out.println(buildingNum +" building do not exist. Please choose the correct building number");
            return;
        }
        building = space.get(bn - 1);
        if(building.size() <= floorNum - 1){
            System.out.println("Floor " + floorNum + "  does not exit in " + buildingNumber + " building");
            return;
        }
        building = space.get(bn - 1);
        for (ArrayList<ConferenceRoom> floors : building){
            for(ConferenceRoom room : floors){
                if(roomNo.equals(String.valueOf(room.getRoomNum()))){
                    System.out.println("Room " + roomNo + " is already exit on the floor " + floorNum + " in building " + buildingNum);
                    return;
                }
            }
        }
        building.get(floorNum - 1).add(new ConferenceRoom(roomNo,floorNum, buildingNum));
        System.out.println("Added conference room " + roomNo + " in " + floorNum + " floor of building "+ buildingNum);
    }

    public void listAllConferenceRoom(){
        int len = building.size();
        ArrayList<String> slots = new ArrayList<>();
        for(int i = 0; i < len; i++){
            building = space.get(i);
            for(ArrayList<ConferenceRoom> floors : building) {
                for (ConferenceRoom room : floors) {
                    boolean[] timeSlot = room.getTime();
                    int start = 0;
                    while (start < timeSlot.length) {
                        if (!timeSlot[start]) {
                            int end = checkAvailableSlot(start, timeSlot);
                            String ans = "{" + (start) + " : " + (end)+ "}";
                            slots.add(ans);
                            start = end;

                        }
                        start++;
                    }
                    if (slots.size() == 0) {
                        slots.add("All Slots are booked");
                    }
                    System.out.println(room.getRoomNum() + " " + room.getFloorNum()+ " " + room.getBuildingNum() + " " + slots.toString());
                    slots.clear();
                }
            }
        }
    }
    public int checkAvailableSlot(int start, boolean[] time){
        int end = start;
        while(end < time.length && !time[end]){
            end++;
        }
        if(end == 25){
            end = 24;
        }
        return end;
    }

    public void bookConferenceRoom(int from, int to, String buildingNum, int floorNum, String roomNum){
        int bn = Integer.parseInt(String.valueOf(buildingNum.charAt(1)));
        int len = space.size();
        int start = from;
        if(len < bn - 1){
            System.out.println(buildingNum +" building do not exist. Please choose the correct building number");
            return;
        }
        building = space.get(bn - 1);
        if(building.size() <= floorNum - 1){
            System.out.println("Floor " + floorNum + "  does not exit in " + buildingNumber + " building");
            return;
        }
        int checkFloor = 0;
        for(ArrayList<ConferenceRoom> floors : building) {
            if(checkFloor == floorNum - 1){
                for (ConferenceRoom room : floors) {
                    if(roomNum.equals(String.valueOf(room.getRoomNum()))){
                        boolean[] timeSlot = room.getTime();
                        while (from <= to && !timeSlot[from]){
                            from++;
                        }
                        if(from < to){
                            System.out.println("Sorry, slot from " + from + " : " + to + " for Conference room "+ roomNum + " is already booked");
                            return;
                        }
                        room.setTime(start, to, true);
                        System.out.println("Booked slot from " + start + " : " + to +" in " + buildingNum + " building on floor " + floorNum);
                        return;
                    }
                }
            } else if (checkFloor > floorNum - 1) {
                break;
            }
            checkFloor++;
        }
        System.out.println("No conference exist on the floor " + floorNum + " with name " + roomNum);
    }

    public void listAllBookedConferenceRoom(){
        int len = building.size();
        ArrayList<String> slots = new ArrayList<>();
        for(int i = 0; i < len; i++){
            building = space.get(i);
            for(ArrayList<ConferenceRoom> floors : building) {
                for (ConferenceRoom room : floors) {
                    boolean[] timeSlot = room.getTime();
                    int start = 0;
                    while (start < timeSlot.length) {
                        if (timeSlot[start]) {
                            int end = checkBookedSlot(start, timeSlot);
                            String ans = "{" + (start) + " : " + (end - 1) + "}";
                            slots.add(ans);
                            start = end;

                        }
                        start++;
                    }
                    System.out.println(room.getRoomNum() + " " + room.getFloorNum()+ " " + room.getBuildingNum() + " " + slots.toString());
                    slots.clear();
                }
            }
        }
    }
    public int checkBookedSlot(int start, boolean[] time){
        int end = start;
        while(end < time.length && time[end]){
            end++;
        }
        return end;
    }

    public void cancelBookedConferenceRoom(int from, int to, String buildingNum, int floorNum, String roomNum){
        int bn = Integer.parseInt(String.valueOf(buildingNum.charAt(1)));
        int len = space.size();
        int start = from;
        if(len < bn - 1){
            System.out.println(buildingNum +" building do not exist. Please choose the correct building number");
            return;
        }
        building = space.get(bn - 1);
        if(building.size() <= floorNum - 1){
            System.out.println("Floor " + floorNum + "  does not exit in " + buildingNumber + " building");
            return;
        }
        int checkFloor = 0;
        for(ArrayList<ConferenceRoom> floors : building) {
            if(checkFloor == floorNum - 1){
                for (ConferenceRoom room : floors) {
                    if(roomNum.equals(String.valueOf(room.getRoomNum()))){
                        boolean[] timeSlot = room.getTime();
                        while (from <= to && timeSlot[from]){
                            from++;
                        }
                        if(from < to){
                            System.out.println("Slot from " + from + " : " + to + " for Conference room "+ roomNum + " is not booked");
                            return;
                        }
                        room.setTime(start, to, false);
                        System.out.println("Booked slot from " + start + " : " + to +" in " + buildingNum + " building on floor " + floorNum + " is canceled");
                        return;
                    }
                }
            } else if (checkFloor > floorNum - 1) {
                break;
            }
            checkFloor++;
        }
        System.out.println("No conference exist on the floor " + floorNum + " with name " + roomNum);
    }
}
