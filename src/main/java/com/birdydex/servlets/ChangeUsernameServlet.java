package com.birdydex.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.birdydex.dao.DBConnection;

@WebServlet(name = "ChangeUsernameServlet", value = "/ChangeUsernameServlet")
public class ChangeUsernameServlet extends HttpServlet {
	
	private String sessionName;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String newUsername = req.getParameter("newUsername");
		
		try {
			
			//The first line creates the database connection object, 
	    	//second line creates link from database object to "Connection" 
	        DBConnection conn = new DBConnection();
	        Connection con = conn.getConnection();
	        
	        //Grabbing session username
	        if(req.getSession().getAttribute("userName") != null) {
				sessionName = req.getSession().getAttribute("userName").toString();
			
	        
	        //Checking it in the DB
	        Statement stm = con.createStatement();
	        ResultSet rs = stm.executeQuery("select * from user where user_username='"+newUsername+"'");
	        
	        if(rs.next()){
	        	resp.sendRedirect("userExists.jsp");
	        	con.close();
	        }
	        else{
	
	        	//Resetting session username
	        	req.getSession().setAttribute("userName", newUsername);
	        	
	        	//Update the username
	            stm.executeUpdate("update user set user_username = '"+newUsername+"' where user_username = '"+sessionName+"' ");
	
	            resp.sendRedirect("changeUsernameSuccess.jsp");
	
	            // close connection
	            con.close();
	        }
        
        } else {
			resp.sendRedirect("sessionError.jsp");
		}
        
		} catch(Exception e){
            System.out.println(e.getMessage());
        }
		
	}

}
