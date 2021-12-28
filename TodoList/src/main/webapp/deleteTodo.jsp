<%@page import="com.rebel.hiren.Dao.TodoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Todo</title>
</head>
<body>

<%  try
		{ if(request.getParameter("delete") != null)
		
		{
			int id = Integer.parseInt(request.getParameter("delete"));
			
			TodoDao tdao = new TodoDao();
			tdao.deleteTodo(id);
			
			session.setAttribute("msg", "deleted todo successfully :) ");
			response.sendRedirect("welcome.jsp");
			
			
		}
		
		}catch(Exception e)
		
		{ e.printStackTrace();}



%>

</body>
</html>