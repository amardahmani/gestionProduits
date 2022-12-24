package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.ProduitDAO;
import model.Produit;

/**
 * Servlet implementation class ProduitController
 */
@WebServlet("/produits")

public class ProduitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ProduitDAO produitDAO;
    public ProduitController() {
        produitDAO = new ProduitDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getSession().getAttribute("admin") != null) {
		try {
			
			String command = request.getParameter("command");
			
			if(command == null) {
				command = "LIST";
			}
			
			switch(command) {
			
			case "DELETE":
				supprimerProduit(request,response);
				break;
			case "LOAD":
				chargerProduit(request,response);
				break;
			case "UPDATE":
				modifierProduit(request,response);
				break;
			default: 
				listProduit(request, response);
				break;
			}
			
		}catch(Exception e) {
			
		}
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void modifierProduit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String designation = request.getParameter("designation");
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		int numero_produit = Integer.parseInt(request.getParameter("numero_produit"));
		Produit produit = new Produit(numero_produit,designation,quantite);
		produitDAO.modifierProduit(produit);
		
		listProduit(request, response);
		
	}

	private void chargerProduit(HttpServletRequest request, HttpServletResponse response)throws Exception {
		// TODO Auto-generated method stub
		int numero_produit = Integer.parseInt(request.getParameter("numero_produit"));
		
		Produit produit = produitDAO.getProduit(numero_produit);
		request.setAttribute("produit", produit);
		RequestDispatcher dispatcher = request.getRequestDispatcher("modifier-produit.jsp");
		dispatcher.forward(request, response);
		
		
	}

	private void supprimerProduit(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// TODO Auto-generated method stub
		int numero_produit = Integer.parseInt(request.getParameter("numero_produit"));
		produitDAO.supprimerProduit(numero_produit);
		listProduit(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}
	
	
	public void listProduit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Produit> produits = produitDAO.listerProduits(); 
		request.setAttribute("produits", produits);
		
		
		//send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("produits.jsp");
		dispatcher.forward(request, response);
		
	}
	
	
}
