package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDAO;
import model.Admin;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getSession().getAttribute("admin") != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("produits.jsp");
			dispatcher.forward(request, response);
		} else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		AdminDAO adminDAO = new AdminDAO();
		
		RequestDispatcher dipatcher;
		
		try {
			Admin admin = adminDAO.checkLogin(username, password);
			if(admin != null) {
				HttpSession session = request.getSession();
				
				session.setAttribute("admin", admin);
				dipatcher = request.getRequestDispatcher("produits.jsp");
				dipatcher.forward(request, response);
			}
			else {
				PrintWriter out = response.getWriter();

				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.include(request, response);

				out.print("<center><h2> Incorect user or password !!<h2>");
			}
			
		}catch(Exception e) {
			
		}
		
	}

}
