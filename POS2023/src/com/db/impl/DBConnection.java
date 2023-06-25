/*
 */
package com.db.impl;

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
            String connectionURL = "jdbc:mysql://localhost:3306/pos2023?autoReconnect=true&useSSL=false";
            String connectionUsername = "root";
            String connectionPassword = "root";
            connection = DriverManager.getConnection(connectionURL, connectionUsername, connectionPassword);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Exception occured in dbConnect, "+ex.toString());
        }
        return connection;
    }
}
