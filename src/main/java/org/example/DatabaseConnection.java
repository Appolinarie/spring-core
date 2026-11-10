package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public  Connection getConnection()throws SQLException{
        String url = "jdbc:postgresql://localhost:1234/University";
        String user = "postgres";
        String password = "1234";

        return DriverManager.getConnection(url, user, password);
    }
}
