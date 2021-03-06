package com.wrox;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(
        name = "chatServlet",
        urlPatterns = "/chat"
)
public class chatServlet extends HttpServlet
{
    
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
            {
		request.setAttribute("sessionList", SessionRegistry.getAllSessions());
        request.getRequestDispatcher("/WEB-INF/jsp/view/chat.jsp")
               .forward(request, response);
            }
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		
		
	}
	
}
