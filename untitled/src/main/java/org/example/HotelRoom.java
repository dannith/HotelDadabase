package org.example;

import java.time.LocalDate;

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

    public boolean isAvailable(LocalDate checkIn, LocalDate checkOut) {
        return true;
    }

    public int getPrice() {
        return price;
    }
}