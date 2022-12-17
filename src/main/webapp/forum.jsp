<%@ page import="com.birdydex.dao.DBConnection" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>




<%--This is a PLACEHOLDER page (No current working functionality) --%>



<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="css/style.css"/>
    <title>Forum</title>
</head>
<body>

<!-- This tag puts the top navigation in! -->
<%@ include file="toolbar.jsp" %>

<div class="forumPage">
    <div class="forumHeader">
        <h1>Forum</h1>
    </div>
    <form action="ForumPostServlet" method="post">
        <label for="postTitle">Post Title:</label>
        <input type="text" id="postTitle" name="pTitle" value=""><br>
        <label for="postText">Post Text:</label>
        <input type="text" id="postText" name="pText" value=""><br><br>
        <input type="radio" id="chicken" name="pImg" value="chicken">
        <label for="chicken">Chicken</label><br>
        <input type="radio" id="loon" name="pImg" value="Loon">
        <label for="loon">Loon</label><br>
        <input type="radio" id="jazzhands" name="pImg" value="jazzHands">
        <label for="jazzhands">Jazzhands</label>
        <input type="submit" value="Submit">
    </form>
    <%
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        DBConnection db = new DBConnection();
        connection = db.getConnection();
        statement = connection.createStatement();
        String QueryString = "SELECT * from forumpost";
        rs = statement.executeQuery(QueryString);
    %>
    <div class="forumBody">
    <%
        while (rs.next()) {
    %>
        <div id="current-post-<%=rs.getString(1)%>" class="forumPost">
            <div class="forumPostImg">
                <img src="images/<%=rs.getString(4)%>.gif" alt="">
            </div>
            <div class="forumPostTextWrapper">
                <div class="forumPostTitle">
                    <h3><%=rs.getString(2)%></h3>
                </div>
                <div class="forumPostText">
                    <p><%=rs.getString(3)%></p>
                </div>
                <div class="modifierButtons">
                    <form action="ForumEditPostServlet" method="post" class="deleteBtn">
                        <p>
                            <input id="EditPostButton" type="submit" value="Edit" required/>
                        </p>
                    </form>
                    <p>|</p>
                    <form action="ForumDeletePostServlet" method="post" class="deleteBtn">
                        <p>
                            <input type="text" id="html-post-id" name="htmlID" value="<%=rs.getString(1)%>">
                            <input id="button" type="submit" value="Delete"  required/>
                        </p>
                    </form>
                </div>
            </div>
        </div>
    <% } %>
    </div>
    <%
        // close all the connections.
        rs.close();
        statement.close();
        connection.close();
    %>
</div>
</body>
</html>
