package com.birdydex.servlets;

import com.birdydex.dao.proxy.DBConnectionProxy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "ForumPostServlet", value = "/ForumPostServlet")
public class ForumPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pTitle = request.getParameter("pTitle");
        String pText = request.getParameter("pText");

        try{
            DBConnectionProxy conn = new DBConnectionProxy();
            Connection con = conn.getConnection();

                Statement statement = con.createStatement();
                statement.executeUpdate("insert into forumpost(postTitle,postText) values('"+pTitle+"','"+pText+"')");

                response.sendRedirect("forum.jsp");

                con.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
