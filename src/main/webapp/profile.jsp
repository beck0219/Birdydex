<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css"/>
<title>User Profile</title>
</head>
<body>

<!-- This tag puts the top navigation in! -->
<%@ include file="toolbar.jsp" %>

<h1>User Profile</h1>
<br>
<div class="profileWrapper">
	<h2>Welcome 
	<%
	if(request.getSession().getAttribute("userName") != null) {
		out.print(pageContext.findAttribute("userName"));
	}
	%>
	!
	<!-- The above tag grabs the "userName" value from the current session described in the LoginServlet -->
	
	</h2>
	<p class="description">You can manage your account here.</p>
	<br><br>
	<div class="profileNav">
		<ul>
			<li><a href="changeUsername.jsp">Change Username</a></li>
			<li><a href="">Change Password</a></li>
			<li><a href="">Change Email</a></li>
			<li><a href="deleteAccount.jsp">Delete Account</a></li>
		</ul>	
	</div>
	<br><br>
	<div>
		<form action="LogoutServlet" method="post">
			<p>
			<input class="logoutBtn" id="button" type="submit" value="Logout" required/>
			</p>
		</form>	
	</div>
</div>

</body>
</html>