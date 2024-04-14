package org.example;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    private final int id;
    private String name;
    private String email;
    private List<Booking> bookings;

    public User(Integer id, String name, String email, List<Booking> bookings) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bookings = bookings;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null) {
            this.email = email;
        }
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking newBooking) {
        this.bookings.add(newBooking);
    }
    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

}