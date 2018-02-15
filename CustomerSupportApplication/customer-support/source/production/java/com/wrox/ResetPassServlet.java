package com.wrox;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ResetPassServlet
 */
@WebServlet(name="/ResetPassServlet", urlPatterns ="/ResetPass")
public class ResetPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWrite''r().append("Served at: ").append(request.getContextPath());
		System.out.println(" redirect to reset pass.jsp");
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/view/ResetPass.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Retrieve all parameters from JSP page
		String oldpass = request.getParameter("oldpass");
		String newpass = request.getParameter("newpass");
		String renewpass = request.getParameter("renewpass");
		HttpSession session = request.getSession();
		String cpass = (String)session.getAttribute("password");
		String username = (String)session.getAttribute("username");
		
		System.out.println(" password ub session "+cpass);
		if(oldpass.equals(null)||oldpass==""||newpass.equals(null)||newpass==""||renewpass.equals(null)||renewpass=="");
		{
			request.setAttribute("msg", "All Fields Are Mendatory");
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/view/ResetPass.jsp").forward(request, response);
		}
		if(!newpass.equals(renewpass))
		{
			request.setAttribute("msg", "Password Does Not Match");
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/view/ResetPass.jsp").forward(request, response);
		}
		if(!cpass.equals(oldpass))
		{
			request.setAttribute("msg", "Incorrect Old Password");
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/view/ResetPass.jsp").forward(request, response);
		}
		else
		{
			MySqlCon UpdateUsers = new MySqlCon();
			int res=UpdateUsers.UpdateUsers(newpass,username);
			System.out.println(" Updatibg passwod"+res);
			request.setAttribute("msg", "Password successfully reset");
			
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/view/login").forward(request, response);
		}
		
		
	}
}


