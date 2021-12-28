<%@page import="javax.sound.midi.SysexMessage"%>
<%@page import="com.rebel.hiren.Dao.UserDao"%>
<%@page import="com.rebel.hiren.Beans.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Account</title>
</head>
<body>
<%@include file="common/message.jsp" %>
<%

 try{
	 if(request.getParameter("delete") != null)
	 {
		 int id = Integer.parseInt(request.getParameter("delete"));
		 
		 UserDao dao = new UserDao();
		 dao.deleteUser(id);
		 
		 session.setAttribute("msg", "we are disappointed to lose you ):");
		 response.sendRedirect("index.jsp");
		 
		 
	 }
	 
	 
	 
	 
 }catch(Exception e)
{
	 System.out.print("sm prb with deleting account from jsp side");
}





%>

</body>
</html>