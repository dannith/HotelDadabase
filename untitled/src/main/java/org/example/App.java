package org.example;
import java.util.List;

public class App
{
    public static void main( String[] args ){
        List<Hotel> myHotels;
        myHotels = HotelDAL.getHotelsFromLocation("Stykkishólmur");
        for(Hotel hotel : myHotels) {
            hotel.setRooms(HotelDAL.getHotelRooms(hotel));
        }
        for(Hotel hotel : myHotels){
            System.out.println(hotel.getName() + ": ");
            for(HotelRoom room : hotel.getRooms()){
                System.out.println(room.getPrice());
            }
        }
    }
}

