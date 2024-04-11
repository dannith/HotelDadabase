package org.example;

import hotels.model.Room;

import java.util.Date;
import java.util.List;


public class Booking {

    private String bookingID;
    private Date checkIn;
    private Date checkOut;
    private List<Room> rooms;
    private int persons;

    //Aðeins BookingController á að nota þennan constructor
    public Booking(String id, Date checkIn, Date checkOut, int nrPers, User owner){
        this.bookingID = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.persons = nrPers;
    }

    //Nota þennan constructor til að senda á gagnagrunn
    public Booking(Date checkIn, Date checkOut, int nrPers, User owner){

    }
}