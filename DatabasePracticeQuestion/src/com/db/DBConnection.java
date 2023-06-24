/*
 */
package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class DBConnection {
    Connection connection = null;
    
    public Connection dbConnect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionURL = "jdbc:mysql://localhost:3306/practice_db?autoReconnect=true&useSSL=false";
            String connectionUsername = "root";
            String connectionPassword = "root";
            connection = DriverManager.getConnection(connectionURL, connectionUsername, connectionPassword);
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: "+ex.toString());
        } catch (SQLException ex) {
            System.out.println("SQLException: "+ex.toString());
        }
        return connection;
    }
}
