package hotels.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public class Booking {
    private DateTime arrival;
    private DateTime departure;
    private Integer nrPersons;
    private Room[] rooms;
    private User owner;

    public Booking(DateTime arrival, DateTime departure, int nrPersons, Room[] rooms, User owner) {
        this.arrival = arrival;
        this.departure = departure;
        this.nrPersons = nrPersons;
        this.rooms = rooms;
        this.owner = owner;
    }

    public DateTime getArrival() {
        return arrival;
    }

    public void setArrival(DateTime arrival) {
        this.arrival = arrival;
    }

    public DateTime getDeparture() {
        return departure;
    }

    public void setDeparture(DateTime departure) {
        this.departure = departure;
    }

    public Integer getNrPersons() {
        return nrPersons;
    }

    public void setNrPersons(Integer nrPersons) {
        this.nrPersons = nrPersons;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
