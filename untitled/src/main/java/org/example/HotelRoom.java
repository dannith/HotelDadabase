package org.example;

import java.time.LocalDateTime;

/******************************************************************************
 *  Nafn    : Lilja Kolbrún Schopka
 *  T-póstur: lks17@hi.is
 *
 *  Lýsing  :
 *
 *
 *
 *
 *****************************************************************************/
public class HotelRoom {

    private int RoomNumber;
    private int persons;
    private int price;
    private int floor;
    private String pictureURL;
    private Hotel hotel;

    public HotelRoom(int RoomNumber, int persons, int floor, int price, String pictureURL) {
        this.RoomNumber = RoomNumber;
        this.persons = persons;
        this.price = price;
        this.floor = floor;
        this.pictureURL = pictureURL;
    }

    public boolean isAvailable(LocalDateTime checkIn, LocalDateTime checkOut) {
        return true;
    }

    public int getPrice() {
        return price;
    }
}