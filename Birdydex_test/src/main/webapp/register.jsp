<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="css/style.css">
    <title>Register page</title>
</head>
<body>

<!-- This tag puts the top navigation in! -->
<%@ include file="toolbar.jsp" %>

<h1>Registration Page</h1>
<br/>
<form action="RegisterServlet" method="post" class="basicForm">
  <p>
    Username: <input type="text" name="username" required/>
  </p>
  <p>
    Password: <input type="password" name="password" required/>
  </p>
  <p>
    Email: <input type="email" name="email" required/>
  </p>
  <p>
    <input id="button" type="submit" value="Register" required/>
  </p>
</form>

<a class="redirect" href="index.jsp">Already have an account? Click here to sign-in!</a>

</body>

</html>
