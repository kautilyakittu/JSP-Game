<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Screen</title>
</head>
<body>
<center>
<h1>Welcome to JSP Game</h1>
<br></br>
<form action="<%=request.getContextPath()%>/Game" method="post">
<input type="hidden" name="action" value="validLogin"/>
<input type="text" name="username" placeholder="Enter your Name"/><br></br>
<input type="submit" name="welcomeSubmit" value="Click here to start the Game"/>

</form>
</center>
</body>
</html>