<%@page import="com.rebel.hiren.Beans.User"%>
<%@page import="com.rebel.hiren.Beans.Todo"%>
<%@page import="com.rebel.hiren.Dao.TodoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Todo</title>
<%@include file="common/css-js-common.jsp" %>
</head>
<body>



<%
		try
{
			
		User user = (User)session.getAttribute("user");

		if(user == null)
		{     	
			session.setAttribute("msg", "Access Denied pls login first!!");
			response.sendRedirect("index.jsp");
		}
		
		else{
	      	   
				if(request.getParameter("edit") != null)
						{
							 int id = Integer.parseInt(request.getParameter("edit"));
							 
							 TodoDao tdao = new TodoDao();
							 Todo todo = tdao.getTodoById(id);
			
%>

		<!-- Todo Updating form -->
		 <div class="col-lg-6 offset-lg-3">
      
      	 <form action="Todoregistry" method="post">
      	  
      	   
		   
		    <input type="hidden" class="form-control" name="tId" value="<%=todo.getTodoId() %>" >
		 
	      	      
	      <div class="form-group">
		    <label for="exampleInputEmail1">Todo Name</label>
		    <input type="text" class="form-control" name="tName" value="<%=todo.getTodoName() %>"  required="required">
		  </div>
		  
		  <div class="form-group">
		    <label for="exampleInputEmail1">Todo Description</label>
		    <input type="text" class="form-control" name="tDes" value="<%=todo.getTodoDescription() %>" required="required">
		  </div>
		 
		  <div class="form-group">
		    <label for="exampleInputEmail1">Todo sDate</label>
		    <input type="date" class="form-control" name="tSdate" value="<%=todo.getTodoSdate() %>" required="required">
		  </div>
		  
		  <div class="form-group">
		    <label for="exampleInputPassword1">Todo eDate</label>
		    <input type="date" class="form-control" name="tEdate" value="<%=todo.getTodoEdate() %>" required="required">
		  </div>
		  
		  <div class="form-group">
            <button type="submit" name="updateTodo" class="btn btn-primary">Update</button>
          </div>
    
        </form>
     
	  </div>
		
		



<%} }  }catch(Exception e)
			{
			  e.printStackTrace();	
			}
%>
</body>
</html>