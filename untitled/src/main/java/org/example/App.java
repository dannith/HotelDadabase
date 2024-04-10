package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class App
{
    public static void main( String[] args ) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:v11.db");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DROP TABLE IF EXISTS R");
            stmt.executeUpdate("CREATE TABLE R(key integer primary key,value double)");
            stmt.executeUpdate("INSERT INTO R VALUES(3, 4)");
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
    }
}

