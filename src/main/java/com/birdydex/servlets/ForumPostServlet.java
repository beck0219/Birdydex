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

    private String sessionN;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pTitle = request.getParameter("pTitle");
        String pText = request.getParameter("pText");
        String pImg = request.getParameter("pImg");
        try{
            DBConnectionProxy conn = new DBConnectionProxy();
            Connection con = conn.getConnection();
                if (request.getSession().getAttribute("userName") != null){
                    sessionN = request.getSession().getAttribute("userName").toString();
                } else {
                    response.sendRedirect("sessionError.jsp");
                }
                Statement statement = con.createStatement();
                statement.executeUpdate("insert into forumpost(postTitle,postText,postImg,postUsername) values('"+pTitle+"','"+pText+"','"+pImg+"','"+sessionN+"')");
                response.sendRedirect("forum.jsp");
                con.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
