package hotels.model;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String number;
    private int nrPersons;
    private int floor;
    private int priceISK;
    private String pictureURL;
    private Hotel hotel;

    public Room(String number, int nrPersons, int floor, int priceISK, String pictureURL, Hotel hotel) {
        this.number = number;
        this.nrPersons = nrPersons;
        this.floor = floor;
        this.priceISK = priceISK;
        this.pictureURL = pictureURL;
        this.hotel = hotel;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getNrPersons() {
        return nrPersons;
    }

    public void setNrPersons(int nrPersons) {
        this.nrPersons = nrPersons;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getPriceISK() {
        return priceISK;
    }

    public void setPriceISK(int priceISK) {
        this.priceISK = priceISK;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
