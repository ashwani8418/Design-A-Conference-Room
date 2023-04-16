package org.example.Enitity;

public class ConferenceRoom {
    private String roomNum;
    private int floorNum;
    private String buildingNum;
    private boolean time[] ;

    public ConferenceRoom(String roomNum, int floorNum, String buildingNum) {
        this.roomNum = roomNum;
        this.floorNum = floorNum;
        this.buildingNum = buildingNum;
        this.time = new boolean[25];
    }

    public String getRoomNum() {
        return roomNum;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public String  getBuildingNum() {
        return buildingNum;
    }

    public boolean[] getTime() {
        return time;
    }

    public void setTime(int from , int to, boolean val) {
        for (int i = from; i <= to ; i++) {
            this.time[i] = val;
        }
    }
}
