package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.List;

public class App
{
    public static void main( String[] args ){
        List<Hotel> myHotels = null;
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

