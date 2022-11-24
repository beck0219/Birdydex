package com.birdydex.servlets;

import com.birdydex.dao.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "DeleteAccountServlet", value = "/DeleteAccountServlet")
public class DeleteAccountServlet extends HttpServlet {

	private String sessionName;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
		//The first line creates the database connection object, 
    	//second line creates link from database object to "Connection" 
        DBConnection conn = new DBConnection();
        Connection con = conn.getConnection();
        
        //Grabbing session username
        if(req.getSession().getAttribute("userName") != null) {
			sessionName = req.getSession().getAttribute("userName").toString();
		} else {
			resp.sendRedirect("sessionError.jsp");
		}
        
        //Checking it in the DB
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from user where user_username='"+sessionName+"'");
        
        if(rs.next()){
        	
        	//This deletes the entire row from the database
        	stm.executeUpdate("delete from user where user_username='"+sessionName+"' ");
        	
        	resp.sendRedirect("accountDeleted.jsp");
        	
        	//Terminates the current login session
    		HttpSession session=req.getSession();  
            session.invalidate();
            
        	con.close();
        }
        else{

            resp.sendRedirect("sessionError.jsp");

            // close connection
            con.close();
        }
        
		} catch(Exception e){
            System.out.println(e.getMessage());
        }
		
	}
	
}
