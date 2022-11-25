<%@ page import="java.sql.DriverManager" %>
<%@ page import="com.birdydex.dao.DBConnection" %>
<%@ page import="java.sql.Driver" %>
<%@ page import="java.sql.Connection" %>
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

        <input type="submit" value="Submit">
    </form>



    <div class="forumBody">
        <div class="forumPost">
            <div class="forumPostImg">
                <img src="images/chicken.gif" alt="">
            </div>
            <div class="forumPostTextWrapper">
                <div class="forumPostTitle">
                    <h3>Chicken Post</h3>
                </div>
                <div class="forumPostText">
                    <p>Details about this chicken I saw!</p>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>
