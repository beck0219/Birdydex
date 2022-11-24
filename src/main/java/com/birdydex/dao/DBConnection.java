package com.birdydex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Please use this to implement DBConnections:
            DBConnectionProxy conn = new DBConnectionProxy();
            Connection con = conn.getConnection();
 */

public class DBConnection {

	//Static variables for the "root" user, password, and JDBC connection
	private static String username = "root";
	private static String password = "";
	private static String connection = "jdbc:mysql://localhost/birdydex"; 
	 private static String driver = "com.mysql.jdbc.Driver";
	 private static Connection con;
	//NOTE: "connection" can be written as "jdbc:mysql://INSERT_HOST_IP/INSERT_DB_NAME"
	//This is why it has localhost (ip address used) and birdydex (Database's name)
	
	
	public Connection getConnection() {

        try {
            Class.forName(driver);

            try {
                con = DriverManager.getConnection(connection, username, password); //Creating connection

            } catch (SQLException e) {
                System.out.println(e); 
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found."); 
        }
        
        return con; //Returning the connection
        
    }
	
}
