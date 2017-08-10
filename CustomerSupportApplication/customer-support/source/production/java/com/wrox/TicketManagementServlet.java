package com.wrox;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TicketManagementServlet
 */
@WebServlet("/Ticket1")
public class TicketManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/view/Ticket1.jsp").forward(request, response);
		
String url = "/index.jsp";
        
        // set action to 'none' if it doesn't exist
        String action = request.getParameter("action");
        if (action == null) {
            action = "none"; 
        }
        
        if (action.equals("displayTickets")) {
            // Get entire list of tickets and add as attribute to be passed to jsp
            int tickets = MySqlCon.selectTickets("MM/dd/yyyy");
            request.setAttribute("tickets", tickets);
            url = "/tickets.jsp"; 
        }
        
        // forward request and response objects to specified URL
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        
	        String url = "/index.jsp";
	                
	        // set action to 'none' if it doesn't exist
	        String action = request.getParameter("action");
	        if (action == null) {
	            action = "displayTickets"; 
	        }
	        
	        if (action.equals("displayTickets")) {
	            // Get entire list of tickets and add as attribute to be passed to jsp
	            int tickets = MySqlCon.selectTickets("MM/dd/yyyy");
	            request.setAttribute("tickets", tickets);
	            url = "/tickets.jsp";
	        } 
	        
	        if (action.equals("searchTicket")) {
	            
	            String searchDate = request.getParameter("datepicker");
	            SimpleDateFormat df1 = new SimpleDateFormat("MM/dd/yyyy");
	            SimpleDateFormat df2 = new SimpleDateFormat("YYYY-MM-dd");
	            try {
	                Date date = df1.parse(searchDate);
	                
	                // Get list of tickets that fall on that date
	                int tickets = MySqlCon.selectTickets(df2.format(date));
	                request.setAttribute("tickets", tickets);
	                url = "/tickets.jsp";

	            } catch (ParseException ex) {
	                Logger.getLogger(TicketManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
	            }
	                        
	        }
	        
	        // forward request and response objects to specified URL
	        getServletContext()
	            .getRequestDispatcher(url)
	            .forward(request, response);
	    }
	    
	    @Override
	    public String getServletInfo() {
	        return "Ticket Management Servlet";
	    }

	}

