package org.example;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;

public class HotelController {

    public static List<Hotel> getHotels(String location){
        return HotelDAL.getHotelsFromLocation(location);
    }

    public static List<HotelRoom> getAvailableRooms(Hotel hotel, LocalDate arrival, LocalDate departure){
        return HotelDAL.getAvailableRooms(hotel, arrival, departure);
    }

    public static void createBooking(Booking booking){
        BookingDAL.createBooking(booking);
    }
    public static void deleteBooking(Booking booking){
        BookingDAL.deleteBooking(booking);
    }
    public static List<Booking> getBookings(User user){
        return BookingDAL.getBookings(user);
    }
}
