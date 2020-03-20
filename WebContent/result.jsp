<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Game Result</title>
</head>
<body>
<center>
<%
String userInput="",comInput="";
if((request.getSession().getAttribute("userInput")==null) || (request.getSession().getAttribute("comInput")==null)){
	response.sendRedirect(request.getContextPath()+"/Game?action=Login");
}
else{
	userInput=request.getSession().getAttribute("userInput").toString();
	comInput=request.getSession().getAttribute("comInput").toString();

}
%>
User input is: <%=userInput %><br>
Computer input is: <%=comInput %><br></br>


<%!
String result(String userInput,String comInput){
	String resultMessage=null;

	if(userInput.equals(comInput)){
		return "Game Draw";
	}
	else{
		if(userInput.equals("rock")){
			if(comInput.equals("scissor")){
				resultMessage= "Player Wins";
			
			}
			else if(comInput.equals("paper")){
				resultMessage= "Computer Wins";
				
			}
		}
		
		if(userInput.equals("paper")){
			if(comInput.equals("rock")){
				resultMessage= "Player Wins";
			}
			else if(comInput.equals("scissor")){
				resultMessage= "Computer Wins";
			}
		}
		
		if(userInput.equals("scissor")){
			if(comInput.equals("paper")){
				resultMessage= "Player Wins";
			}
			else if(comInput.equals("rock")){
				resultMessage= "Computer Wins";
			}
		}
		return resultMessage;
	}
}
%>

<%=result(userInput,comInput) %><br>

<a href="game.jsp">Click here to play Again!!</a><br></br>

<form action="<%=request.getContextPath()%>/Input" method="get">
<input type="hidden" name="action" value="destroy">
<input type="submit" value="logout" /><br>
</form>

</center>
</body>
</html>