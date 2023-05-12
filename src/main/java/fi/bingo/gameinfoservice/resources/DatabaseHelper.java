package fi.bingo.gameinfoservice.resources;

import java.sql.*;

public class DatabaseHelper {
    
    public Connection connectToDb(String url, String user, String password){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public ResultSet makeQueryToDb(Connection conn, String dbQuery){
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(dbQuery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }
}