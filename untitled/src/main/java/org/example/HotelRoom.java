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

    @Override
    public String toString() {
        return "HotelRoom{" +
                "RoomNumber=" + RoomNumber +
                ", persons=" + persons +
                ", price=" + price +
                ", floor=" + floor +
                ", pictureURL='" + pictureURL +
                '}';
    }

    private int floor;
    private String pictureURL;

    public HotelRoom(int RoomNumber, int persons, int floor, int price, String pictureURL) {
        this.RoomNumber = RoomNumber;
        this.persons = persons;
        this.price = price;
        this.floor = floor;
        this.pictureURL = pictureURL;
    }

    public int getRoomNumber() {
        return RoomNumber;
    }

    public int getPersons() {
        return persons;
    }

    public int getFloor() {
        return floor;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public int getPrice() {
        return price;
    }
}