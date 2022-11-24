package com.birdydex.dao.proxy;

import java.sql.Connection;

import com.birdydex.dao.DBConnection;

public class DBConnectionProxy {
	
	private static Connection con;

	private DBConnection dbCon = new DBConnection();
	
	public Connection getConnection() {
		return dbCon.getConnection();
	}
	
}

