package org.example;

import hotels.model.Room;

import java.awt.print.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAL {

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

    public static List<Booking> getBookings(User user){
        List<Booking> bookings = new ArrayList<>();
        if(connection == null) Connect();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Booking WHERE OwnerLastName=? AND OwnerEmail=?");
            stmt.setString(1, user.getLastName());
            stmt.setString(2, user.getEmail());
            ResultSet results = stmt.executeQuery();
            while(results.next()){
                PreparedStatement rmstmt = connection.prepareStatement(
                        "SELECT * FROM Room WHERE HotelName, Number EXIST(" +
                                "SELECT * FROM Booking_Room WHERE BookingID=?)");
                rmstmt.setInt(1,results.getInt(1));
                ResultSet rmResults = rmstmt.executeQuery();
                List<HotelRoom> rooms = new ArrayList<>();
                while(rmResults.next()){
                    HotelRoom room = new HotelRoom(
                            rmResults.getInt(3),
                            rmResults.getInt(4),
                            rmResults.getInt(5),
                            rmResults.getInt(6),
                            rmResults.getString(7)
                    );
                    rooms.add(room);
                }
                Booking newBooking = new Booking(
                        results.getInt(1),
                        results.getDate(2),
                        results.getDate(3),
                        results.getInt(4),
                        rooms
                );
                bookings.add(newBooking);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return bookings;
    }

}
