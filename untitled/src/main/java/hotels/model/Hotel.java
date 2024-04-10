package hotels.model;

import java.util.ArrayList;
import java.util.List;


public class Hotel {
    private String name;
    private String location;
    private String address;
    private String pictureURL;
    private Room[] rooms;

    public Hotel(String name, String location, String address, String pictureURL, Room[] rooms) {
        this.name = name;
        this.location = location;
        this.address = address;
        this.pictureURL = pictureURL;
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }
}
