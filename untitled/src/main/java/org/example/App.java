package org.example;
import java.util.List;

public class App
{
    public static void main( String[] args ){
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
    }
}

