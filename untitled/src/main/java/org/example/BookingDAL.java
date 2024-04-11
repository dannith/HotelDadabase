package org.example;

import hotels.model.Room;

import java.awt.print.Book;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
                        "SELECT * FROM Room WHERE (HotelName, Number) IN(" +
                                "SELECT HotelName, RoomNumber FROM Booking_Room WHERE BookingID=?)");
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
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
                String arrival =  results.getString("Arrival");
                String departure =  results.getString("Arrival");
                Booking newBooking = new Booking(
                        results.getInt(1),
                        LocalDate.parse(arrival, formatter),
                        LocalDate.parse(departure, formatter),
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

    public static List<HotelRoom> getAvailableRooms(Hotel hotel, LocalDate arrival, LocalDate departure){
        List<HotelRoom> rooms = new ArrayList<>();
        if(connection == null) Connect();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT r.Number, r.NrPerson, r.Floor, r.Price_Isk, r.PictureUrl FROM Room AS r " +
                    "JOIN Hotel AS h ON ((r.HotelName, r.HotelAddress) = (h.HotelName, h.Address)) " +
                    "JOIN Booking_Room AS br ON ((br.HotelName, br.RoomNumber) = (r.HotelName, r.Number)) " +
                    "JOIN Booking AS b ON (b.BookingID = br.BookingID)\n" +
                    "WHERE (b.arrival NOT BETWEEN ? AND ?) " +
                    "AND (b.departure NOT BETWEEN ? AND ?)" +
                    "AND NOT (b.arrival > ? AND b.departure < ?)" +
                    "AND (h.HotelName, h.Address) = (?, ?)");
            stmt.setDate(1, Date.valueOf(arrival));
            stmt.setDate(2, Date.valueOf(departure));
            stmt.setDate(3, Date.valueOf(arrival));
            stmt.setDate(4, Date.valueOf(departure));
            stmt.setDate(5, Date.valueOf(arrival));
            stmt.setDate(6, Date.valueOf(departure));
            stmt.setString(7, hotel.getName());
            stmt.setString(8, hotel.getAddress());
            ResultSet results = stmt.executeQuery();
            while(results.next()){
                HotelRoom room = new HotelRoom(
                        results.getInt(1),
                        results.getInt(2),
                        results.getInt(3),
                        results.getInt(4),
                        results.getString(5)
                );
                rooms.add(room);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return rooms;
    }

    public static void createBooking(User user, List<HotelRoom> rooms, LocalDate arrival, LocalDate departure, int nrPersons){
        if(connection == null) Connect();
        try {
            PreparedStatement userExists = connection.prepareStatement("SELECT * FROM User Where (LastName, Email) = (?, ?)");
            userExists.setString(1, user.getLastName());
            userExists.setString(2, user.getEmail());
            ResultSet userFound = userExists.executeQuery();
            if(!userFound.next()){
                System.out.println("User not found... Creating new user in DB..");
                createUser(user);
            }
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO Booking('Arrival', 'Departure', 'nrPerson', 'OwnerLastName', 'OwnerEmail') VALUES(?, ?, ?, ?, ?)");
            stmt.setString(1, arrival.toString());
            stmt.setString(2, departure.toString());
            stmt.setInt(3, nrPersons);
            stmt.setString(4, user.getLastName());
            stmt.setString(5, user.getEmail());
            stmt.executeUpdate();
            ResultSet key = stmt.getGeneratedKeys();
            for(HotelRoom room: rooms){
                PreparedStatement rmStmt = connection.prepareStatement("INSERT INTO Booking_Room VALUES(?, ?, ?)");
                // VANTAR
            }

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    private static void createUser(User user){
        if(connection == null) Connect();
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO User VALUES(?, ?, ?)");
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

}
