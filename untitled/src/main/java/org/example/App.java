package org.example;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class App
{
    public static void main( String[] args ){
        /*
        List<Hotel> myHotels;
        myHotels = HotelDAL.getHotelsFromLocation("Stykkishólmur");
        for(Hotel hotel : myHotels){
            System.out.println(hotel.getName() + ": ");
            for(HotelRoom room : hotel.getRooms()){
                System.out.println(room.getPrice());
            }
        }
        User user = new User(1, "Gunni", "Arnar", "a@a.is", null);
        user.setBookings(BookingDAL.getBookings(user));
        System.out.println(user.getBookings().size());
        */
        User user = new User(1, "Georg", "Gunnars", "u@z.is", null);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        LocalDate arrival = LocalDate.parse("2024-04-11", formatter);
        LocalDate departure = LocalDate.parse("2024-04-15", formatter);
        BookingDAL.createBooking(user, null, arrival, departure, 4);
    }
}

