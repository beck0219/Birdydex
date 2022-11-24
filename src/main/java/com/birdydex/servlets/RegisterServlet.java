package com.birdydex.servlets;

import javax.servlet.*;
import javax.servlet.http.*;

import com.birdydex.dao.DBConnection;
import com.birdydex.dao.proxy.DBConnectionProxy;

import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String email = request.getParameter("email");

                // Database
                try{
                	//The first line creates the database connection object, 
                	//second line creates link from database object to "Connection" 
                	DBConnectionProxy conn = new DBConnectionProxy();
                    Connection con = conn.getConnection();
                    
                    Statement stm = con.createStatement();
                    ResultSet rs = stm.executeQuery("select * from user where user_username='"+username+"'");
                    
                    if(rs.next()){
                    	response.sendRedirect("userExists.jsp");
                    	con.close();
                    }
                    else{
                    	
                    	// insert data into our database
                        Statement statement = con.createStatement();
                        statement.executeUpdate("insert into user(user_username,user_password,user_email) values('"+username+"','"+password+"','"+email+"')");

                        response.sendRedirect("accountCreated.jsp");

                        // close connection
                        con.close();
                    }
                    
                    

                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
}
