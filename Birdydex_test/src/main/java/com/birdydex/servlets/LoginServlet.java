package com.birdydex.servlets;

import javax.servlet.*;
import javax.servlet.http.*;

import com.birdydex.dao.DBConnection;
import com.birdydex.dao.proxy.DBConnectionProxy;

import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

   
        // Database
        try{
        	//The first line creates the database connection object, 
        	//second line creates link from database object to "Connection" 
            DBConnectionProxy conn = new DBConnectionProxy();
            Connection con = conn.getConnection();

            // get data from login table using query
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from user where user_username='"+username+"' and user_password= '"+password+"'");

            if (rs.next()){
                // if username and password true then go to Home.html file
            	request.getSession().setAttribute("userName", username);
                response.sendRedirect("profile.jsp");
            }else {
                // wrong username or password
                response.sendRedirect("loginFailed.jsp");
            }
            // close connection
            con.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
