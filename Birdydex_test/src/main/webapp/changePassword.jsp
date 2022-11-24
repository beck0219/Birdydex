<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css"/>
<title>Change Password</title>
</head>
<body>

<!-- This tag puts the top navigation in! -->
<%@ include file="toolbar.jsp" %>

<h1>User Profile</h1>
<br>
<div>
	<p>You can change your password here using the form below.</p>
	<br>
	<form action="ChangePasswordServlet" method="post" class="basicForm">
		<p>
        	Existing Password: <input type="text" name="OldPassword" required/>
    	</p>
    	<p>
        	New Password: <input type="text" name="newPassword" required/>
    	</p>
		<p>
	        <input id="button" type="submit" value="Change Password" required/>
	    </p>
	</form>
</div>

</body>
</html>