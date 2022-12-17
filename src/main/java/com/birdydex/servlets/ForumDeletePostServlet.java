package com.birdydex.servlets;

import com.birdydex.dao.DBConnection;
import com.birdydex.dao.proxy.DBConnectionProxy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

@WebServlet(name = "ForumDeletePostServlet", value = "/ForumDeletePostServlet")
public class ForumDeletePostServlet extends HttpServlet {

    private String sessionName;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String jspID = request.getParameter("htmlID");


        Statement statement = null;
        ResultSet rs = null;




        try{
            DBConnectionProxy conn = new DBConnectionProxy();
            Connection con = conn.getConnection();

            statement = con.createStatement();
            String QueryString = "SELECT * from forumpost";
            rs = statement.executeQuery(QueryString);

            String postUsername = null;
            String currentUser = null;

            if (request.getSession().getAttribute("userName") == null){
                response.sendRedirect("index.jsp");

            }else if(request.getSession().getAttribute("userName") != null){
                currentUser = request.getSession().getAttribute("userName").toString();
                postUsername = rs.toString();

                if (currentUser != postUsername){
//                    response.sendRedirect("sessionError.jsp");
                }else{
                    statement.executeUpdate("delete from forumpost where postId = '"+jspID+"' and'"+currentUser+"' = postUsername");
                    response.sendRedirect("forum.jsp");
                }

            }
            con.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


}
