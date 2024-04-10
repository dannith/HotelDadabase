package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class HotelDAL {
    private static Connection connection;

    private static void Connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:v11.db");
        } catch (SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Hotel> getHotelsFromLocation(String location){
        List<Hotel> hotels = new ArrayList<>();
        if(connection == null) Connect();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Hotel WHERE Location=?");
            stmt.setString(1, location);
            ResultSet results = stmt.executeQuery();
            while(results.next()){
                Hotel hotel = new Hotel(
                        results.getString(1),
                        results.getString(2),
                        results.getString(3),
                        results.getString(4),
                        results.getString(5),
                        null);
                hotels.add(hotel);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return hotels;
    }

    public static List<HotelRoom> getHotelRooms(Hotel hotel){
        List<HotelRoom> rooms = new ArrayList<>();
        if(connection == null) Connect();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Room WHERE HotelName=? AND HotelAddress=?");
            stmt.setString(1, hotel.getName());
            stmt.setString(2, hotel.getAddress());
            ResultSet results = stmt.executeQuery();
            while(results.next()){
                HotelRoom room = new HotelRoom(
                        results.getInt(3),
                        results.getInt(4),
                        results.getInt(5),
                        results.getInt(6),
                        results.getString(7)
                );
                rooms.add(room);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return rooms;
    }
}
