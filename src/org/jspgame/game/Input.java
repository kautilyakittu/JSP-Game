package org.jspgame.game;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Input
 */
@WebServlet("/Input")
public class Input extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Input() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String username=request.getParameter("username");
		
		
		switch(action) {
		case "destroy":
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath()+"/Game?action=Login");
			break;
		case "Succesful":
			
			request.getRequestDispatcher("game.jsp").forward(request, response);
			break;
			 default:
				 break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		input(request,response);
	}
	
	public void input(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userInput=request.getParameter("userInput");
		String comInput=request.getParameter("comInput");
		HttpSession newSession=request.getSession(true);
		newSession.setAttribute("userInput", userInput);
		newSession.setAttribute("comInput", comInput);
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

}
