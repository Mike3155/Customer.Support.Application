
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <c:if test="${message}">
        <b></b><br /><br />
    </c:if>
    <form method="get" action="<c:url value="/Ticket1" />">
<!DOCTYPE html>
<html>

<head>
  
    <link rel="stylesheet" href="css/style.css">
    <title>Help Desk</title>
    
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
        $( function() {
          $( "#datepicker" ).datepicker();
        } );
        </script>

</head>

<body>
    <div class="container">
       
    <h1 class="colored-font">Tickets</h1>
    
    <div class="row">   
        <form method="post" action="ticketManagement?action=searchTicket">

            <input type="hidden" name="action" value="searchTicketByDate">
            <span>
                <input id="datepicker" name="datepicker" type="text" required="required">   
            </span>
            <button id="searchTicket" name="searchTicket" type="submit" class="btn btn-primary" >
                Search Tickets by Date
            </button>
            
        </form>
    </div>
    
      <table border="1" width="800" cellpadding="5">
        <thead>
          <tr>
            <th>Ticket Number</th>
            <th>Ticket Date</th>
            <th>Ticket Details</th>
          </tr>
        </thead>
        <tbody>
            <c:forEach items="${tickets}" var="ticket">
                <tr>
                    <td>${ticket.ticket_number}</td>
                    <td>${ticket.ticket_date}</td>
                    <td>$ ${ticket.ticket_details}</td>
                </tr>    
            </c:forEach>  
        </tbody>
      </table> 
      
      <!-- Button (Double) -->
    <button id="" name="allTickets" class="btn btn-primary" 
        onclick="window.location.href='ticketManagement?action=displayTickets'" >All Tickets
   </button>
    
      
    </div>
</body>
</html>


<style>

.container {
	padding-top: 10px;
	padding-left: 30px;
	font-family: sans-serif;
}

.colored-font {
	color:#099;		
}

.label {
	font-weight: bold;
	width: 100px;
	display: inline-block;
	float:left;
}

.row {
	margin-bottom: 15px;
	width: 340px;
	vertical-align:top;	
}

.right-align {
	float:right;	 
}

.link {
	clear:both;	
}

.buttons {
	padding-right: 20px;	
}

table {
    border-width: thin;
    border-spacing: 2px;
    border-style: none;
    border-color: black;
	border-collapse: collapse;
	margin-bottom:10px;
}

td, th {
    border: 1px solid black;
}

</style>

