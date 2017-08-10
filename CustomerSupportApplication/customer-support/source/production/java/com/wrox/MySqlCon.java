package com.wrox;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlCon {

	public String getUserDetails(String userID) {
		String pass = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=customersupport", "sa",
					"charlotte1");
			// System.out.println("Inside get user details");
			// here customer support is database name, root is user name and
			// password
			PreparedStatement stmt = con.prepareStatement("select password from users where userid=?");
			stmt.setString(1, userID);
			ResultSet rs = stmt.executeQuery();
			System.out.println("Success");
			while (rs.next()) {
				pass = rs.getString(1);
				System.out.println("Success password"+ pass);
			}
		} catch (

		Exception e) {
			System.out.println("exception " + e);
			System.out.println("exception " + e.getMessage());
		}
		return pass;
	}
	
	public void insertUsers(String UserID, String Email, String FirstName, String LastName, String password) {
	

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=customersupport", "sa",
					"charlotte1");

			PreparedStatement stmtInsert = con.prepareStatement("insert into users values(?,?,?,?,?)");
			stmtInsert.setString(1, UserID);
			stmtInsert.setString(2, Email);
			stmtInsert.setString(3, FirstName);
			stmtInsert.setString(4, LastName);
			stmtInsert.setString(5, password);
			int rsInsert = stmtInsert.executeUpdate();

		} catch (

		Exception e) {
			System.out.println("exception " + e);
			System.out.println("exception " + e.getMessage());
		}

	}

	
	public int UpdateUsers(String password,String username) {
		int rsUpdate=0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=customersupport", "sa",
					"charlotte1");

			PreparedStatement stmtUpdate = con.prepareStatement("update users set password=? where userid=?");
			stmtUpdate.setString(1, password);
			stmtUpdate.setString(2, username);
			 rsUpdate = stmtUpdate.executeUpdate();

		} catch (Exception e) {
			System.out.println("exception " + e);
			System.out.println("exception " + e.getMessage());
		}
		
		return rsUpdate;

	}
	
	/****************************************************************************************/
	
	public static int selectTickets(String ticket_date) {
		int rsSelect=0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=customersupport", "sa",
					"charlotte1");

			PreparedStatement stmtSelect = con.prepareStatement("Select ticket_number, ticket_date, ticket_details " +
		            "From tickets");
			stmtSelect.setString(1, ticket_date);
			//stmtUpdate.setString(2, username);
			 rsSelect = stmtSelect.executeUpdate();

		} catch (Exception e) {
			System.out.println("exception " + e);
			System.out.println("exception " + e.getMessage());
		}
		
		return rsSelect;

	}
}

	/**
	public static List<Ticket1> selectTickets() {
		Ticket1 ticket;
        List<Ticket1> tickets = new ArrayList<>();
        Connection connection =  null;
        
        try {
            
            // Create connection
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=customersupport", "sa",
					"charlotte1");
            
            // SQL query to get all the tickets
            PreparedStatement stmt = con.prepareStatement("Select ticket_number, ticket_date, ticket_details " +
            "From tickets");
            
            // Get resultset from database
            ResultSet rs = stmt.executeQuery();
            
            // Get all tickets and add to the tickets list
            while(rs.next()) {
                
                ticket = new Ticket1();
                
                int ticket_number = rs.getInt("ticket_number");
                String ticket_date = rs.getString("ticket_date");
                String ticket_details = rs.getString("ticket_details");

                ticket.setTicket_number(ticket_number);
                ticket.setTicket_date(ticket_date);
                ticket.setTicket_details(ticket_details);
              
                tickets.add(ticket);
            }
           
        
 
            // Close resultset, statement and connection
            rs.close();
            stmt.close();
            connection.close();
        
        } catch (

        		Exception e) {
        			System.out.println("exception " + e);
        			System.out.println("exception " + e.getMessage());
        		}
		return tickets;

        	}


	// Get a ticket based on date
    public static List<Ticket1> selectTicketByDate(String ticketDate) {

        Ticket1 ticket;
        List<Ticket1> tickets = new ArrayList<>();
        Connection connection =  null;
        
        try {
            
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=customersupport", "sa",
					"charlotte1");
            
            // SQL query to get all the tickets
            PreparedStatement stmt = con.prepareStatement("Select ticket_number, ticket_date, ticket_details " +
            "From tickets");
          
            // Get resultset from database
            ResultSet rs = stmt.executeQuery();
            
            // Get all tickets and add to the tickets list
            while(rs.next()) {
                
                ticket = new Ticket1();
                
                int ticket_number = rs.getInt("ticket_number");
                String ticket_date = rs.getString("ticket_date");
                String ticket_details = rs.getString("ticket_details");

                ticket.setTicket_number(ticket_number);
                ticket.setTicket_date(ticket_date);
                ticket.setTicket_details(ticket_details);
              
                tickets.add(ticket);
            }
           
            // Close resultset, statement and connection
            rs.close();
            stmt.close();
            connection.close();
        
        } catch (

        		Exception e) {
        			System.out.println("exception " + e);
        			System.out.println("exception " + e.getMessage());
        		}
		return tickets;

        	}
    }
*/
   




	
		


