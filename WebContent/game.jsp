<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Game</title>
</head>
<body>
<center>

<% 
String username=null;
if((request.getSession().getAttribute("username")==null)){
	response.sendRedirect(request.getContextPath()+"/Game?action=Login");
}
else{
	username=request.getSession().getAttribute("username").toString();
	
}
%>

<form action="<%=request.getContextPath()%>/Input" method="post">

<h2>Welcome to the game <%=username %></h2>
<input type="submit" name="userInput" value="rock"/>
<input type="submit" name="userInput" value="paper"/>
<input type="submit" name="userInput" value="scissor"/>
<input type="hidden" name="comInput" id="comInput"/>
</form>
<script type="text/javascript">
	const input = ["rock", "paper", "scissor"];
    document.getElementById('comInput').value = input[Math.floor(Math.random() * input.length)];
    var buttons = document.getElementById("rock");
    buttons.innerHTML = '<img src="rock.jpg" />'
    
</script>
</center>
</body>
</html>