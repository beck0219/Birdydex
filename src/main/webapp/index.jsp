<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/style.css"/>
    <title>JSP - Hello World</title>
</head>
<body>

<!-- This tag puts the top navigation in! -->
<%@ include file="toolbar.jsp" %>

<h1>Login</h1>
<br/>
<form action="LoginServlet" method="post" class="basicForm">
    <p>
        Username: <input type="text" name="username" required/>
    </p>
    <p>
        Password: <input type="password" name="password" required/>
    </p>
    <p>
        <input id="button" type="submit" value="Login" required/>
    </p>
</form>
<a class="redirect" href="register.jsp">New user? Click HERE to register!</a>
</body>
</html>