package org.example;
import java.awt.print.Book;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args ){
        User user = new User(1, "Georg", "u@z.is", null);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate arrival = LocalDate.parse("2024-04-11", DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate departure = LocalDate.parse("2024-04-15", DateTimeFormatter.ISO_LOCAL_DATE);
        Hotel hotel = HotelController.getHotels("Akureyri").get(0);
        List<HotelRoom> avRooms = HotelController.getAvailableRooms(hotel, arrival, departure);
        List<HotelRoom> bookRooms = new ArrayList<>();
        for(HotelRoom room : avRooms){
            System.out.println(room);
        }
        bookRooms.add(avRooms.get(1));
        bookRooms.add(avRooms.get(2));

        System.out.println();
        Booking bokun = new Booking(arrival, departure, 5, user, hotel, bookRooms);
        HotelController.createBooking(bokun);
        System.out.println(bokun);
        List<Booking> bks = HotelController.getBookings(user);
        List<HotelRoom> newAV = HotelController.getAvailableRooms(hotel, arrival, departure);
        for(HotelRoom room : avRooms){
            System.out.println(room);
        }
    }
}

