package org.example.Enitity;

import java.util.ArrayList;
import java.util.List;

public class Floor extends ArrayList<Floor> {
    ArrayList<ConferenceRoom> floor;
    public Floor(ArrayList<ConferenceRoom> floor) {
        this.floor = new ArrayList<>();
    }
}
