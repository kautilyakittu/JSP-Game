package org.jspgame.game;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Game
 */
@WebServlet("/Game")
public class Game extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Game() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		switch(action) {
		case "Login":
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;
		
		default:
			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action=request.getParameter("action");
		switch(action) {
		case "validLogin":
			validate(request,response);
			break;
		
		default:
			break;
		}
	}
	
	public void validate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		String username=request.getParameter("username");
		String playerWinCount=request.getParameter("playerWinCount");
		String computerWinCount=request.getParameter("computerWinCount");
		if(username.isEmpty()) {
			
			response.sendRedirect(request.getContextPath()+"/Game?action=Login");
		}
		else {
			request.getSession().invalidate();
			HttpSession newSession=request.getSession(true);
			newSession.setMaxInactiveInterval(300);
			newSession.setAttribute("username", username);
			response.sendRedirect(request.getContextPath()+"/Input?action=Succesful");
		}
	}


}
