<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css"/>
<title>Delete Account</title>
</head>
<body>

<!-- This tag puts the top navigation in! -->
<%@ include file="toolbar.jsp" %>

<h1>User Profile</h1>
<br>
<p>This is where you can completely delete your account and all information regarding it.</p>
<br><br>
<h3>If you're certain you'd like to delete your account, please press the button below.</h3>
<br>
<form action="DeleteAccountServlet" method="post" class="deleteBtn">
	<p>
        <input id="button" type="submit" value="Delete Account" required/>
    </p>
</form>

</body>
</html>