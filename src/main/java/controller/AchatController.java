package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AchatDAO;
import model.Achat;

/**
 * Servlet implementation class AchatController
 */
@WebServlet("/achats")
public class AchatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AchatDAO achatDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AchatController() {
        super();
        achatDAO = new AchatDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getSession().getAttribute("admin") != null) {
		try {
			ArrayList<Achat> achats = achatDAO.ListerAchat();
			request.setAttribute("achats", achats);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("liste-achats.jsp");
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
		}}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
