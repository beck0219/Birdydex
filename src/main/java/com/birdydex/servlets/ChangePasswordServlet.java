package com.birdydex.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.birdydex.dao.proxy.DBConnectionProxy;

@WebServlet(name = "ChangePasswordServlet", value = "/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	
	private String sessionName;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Empty for the time being
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//The first line creates the database connection object, 
    	//second line creates link from database object to "Connection" 
		DBConnectionProxy conn = new DBConnectionProxy();
        Connection con = conn.getConnection();
        
        if(req.getSession().getAttribute("userName") != null) {
			sessionName = req.getSession().getAttribute("userName").toString();

			Statement stm = null;
			try {
				stm = con.createStatement();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			try {
				ResultSet rs = stm.executeQuery("select * from user where user_username='" + sessionName + "'");
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
