package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
        return null;
    }

}
