package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AchatDAO;
import dao.ProduitDAO;
import model.Achat;

/**
 * Servlet implementation class NouvelAchat
 */
@WebServlet("/NouvelAchat")
public class NouvelAchat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ProduitDAO produitDAO;
	AchatDAO achatDAO;
    public NouvelAchat() {
        super();
        // TODO Auto-generated constructor stub
        produitDAO = new ProduitDAO();
        achatDAO = new AchatDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<String> designations = null;
		if (request.getSession().getAttribute("admin") != null) {
			try {
				designations = produitDAO.listDesignation();
			} catch (InstantiationException | IllegalAccessException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("designations", designations);
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("ajouter-achat.jsp");
		dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String designation = request.getParameter("designation");
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		String date = request.getParameter("date");
		
		Achat achat = new Achat(designation,quantite,date);
		
		try {
			produitDAO.produitAchat(quantite, designation);
			achatDAO.ajouterAchat(achat);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.sendRedirect("produits");
		
	}

}
