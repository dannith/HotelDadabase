package hotels.model;

import java.util.ArrayList;
import java.util.List;


public class Hotel {
    private String name;
    private String location;
    private String address;
    private String pictureURL;
    private List<Integer> rooms;

    public Hotel(String name, String location, String address, String pictureURL, List<Integer> rooms) {
        this.name = name;
        this.location = location;
        this.address = address;
        this.pictureURL = pictureURL;
        this.rooms = rooms;
    }
}
