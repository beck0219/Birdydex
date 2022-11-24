<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css"/>
<title>Change Username</title>
</head>
<body>

<!-- This tag puts the top navigation in! -->
<%@ include file="toolbar.jsp" %>

<h1>User Profile</h1>
<br>
<div>
	<p>You can change your username here using the form below. Please note, you cannot change to a username that already exists.</p>
	<br>
	<form action="ChangeUsernameServlet" method="post" class="basicForm">
		<p>
        	New Username: <input type="text" name="newUsername" required/>
    	</p>
		<p>
	        <input id="button" type="submit" value="Change Username" required/>
	    </p>
	</form>
</div>

</body>
</html>