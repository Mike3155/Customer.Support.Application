package com.wrox;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet( name = "/CreateAccount", urlPatterns = "/Register")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String UserID = request.getParameter("ID");
		String Email = request.getParameter("email");
		String FirstName = request.getParameter("fname");
		String LastName = request.getParameter("lname");
		String password = request.getParameter("pssword");
		
		MySqlCon insertUsers = new MySqlCon();
		insertUsers.insertUsers(UserID, Email, FirstName, LastName, password);
		
		RequestDispatcher r = getServletContext().getRequestDispatcher("/WEB-INF/jsp/view/login.jsp");
		r.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher r = getServletContext().getRequestDispatcher("/WEB-INF/jsp/view/Register.jsp");
		r.forward(request, response);
		
	}

}
