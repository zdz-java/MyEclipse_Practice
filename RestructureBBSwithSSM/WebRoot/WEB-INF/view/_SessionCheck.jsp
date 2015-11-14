<%
	String adminLogined = (String)session.getAttribute("adminLogined");
 	if(adminLogined==null||!adminLogined.equalsIgnoreCase("true"))
 	{
 		response.sendRedirect("login.jsp");
 		return;
 	}
 	
%>