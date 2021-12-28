<%@page import="com.rebel.hiren.Beans.Todo"%>
<%@page import="java.util.List"%>
<%@page import="com.rebel.hiren.Dao.TodoDao"%>
<%@page import="com.rebel.hiren.Beans.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<%@include file="common/css-js-common.jsp" %>

<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies.

		try{
		User user = (User)session.getAttribute("user");
    
		if(user == null  )
		{
			session.setAttribute("msg", "plese first login  !!");
			response.sendRedirect("index.jsp");
			
		}else
		
		{
		
	
  
   
%>






<nav class="navbar navbar-expand-lg navbar-light justify-content-between" style="background-color: #e3f2fd;" >
  <a class="navbar-brand" href="#">Todo</a>
  
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav inline">     
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <%=user.getuName() %>
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="updateProfile.jsp?edit=<%=user.getuId()%>">Edit your account</a>
          <a class="dropdown-item" href="deleteUser.jsp?delete=<%=user.getuId()%>">Delete your account</a>
          <a class="dropdown-item" href="#" ><form action="logout"> <input type="submit" value="LogOut"></form></a>
        </div>
      </li>
    </ul>
  </div>
</nav>



</head>
<br><br>
<body>



  	
<%@include file="common/message.jsp" %>



<!-- Todo Registration Button -->

<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
  Add New Todo
</button>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Registration</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      
      	 <form action="Todoregistry" method="post">
      	  
	      	      
	      <div class="form-group">
		    <label for="exampleInputEmail1">Todo Name</label>
		    <input type="text" class="form-control" name="tName"  placeholder="Enter Todo Name" required="required">
		  </div>
		  
		  <div class="form-group">
		    <label for="exampleInputEmail1">Todo Description</label>
		    <input type="text" class="form-control" name="tDes" placeholder="Enter Todo Description" required="required">
		  </div>
		 
		  <div class="form-group">
		    <label for="exampleInputEmail1">Todo sDate</label>
		    <input type="date" class="form-control" name="tSdate" placeholder="Starting Date" required="required">
		  </div>
		  
		  <div class="form-group">
		    <label for="exampleInputPassword1">Todo eDate</label>
		    <input type="date" class="form-control" name="tEdate" placeholder="Ending Date" required="required">
		  </div>
		  
		  <div class="form-group">
            <button type="submit" name="newTodo" class="btn btn-primary">Add</button>
          </div>
    
        </form>
     
	  </div>
      
      
    </div>
  </div>
</div>
<br><br><br>



<!-- Table to show user's Todo list -->
<div class="col-lg-6 offset-lg-3">
<table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">Todo Name</th>
      <th scope="col">Todo Description</th>
      <th scope="col">Todo Start Date</th>
      <th scope="col">Todo End Date</th>
    </tr>
  </thead>
  <%
  		int uId = user.getuId();
  
  		TodoDao tdao = new TodoDao();
		List<Todo> list = tdao.getAllTodo(uId);
		
		//.setAttribute("todo", list);
		    		
		 for(Todo todo : list)
		 {
  
  %>
    <tbody>
  	  <tr>
  	     <td><%=todo.getTodoName() %></td>
  	     <td><%=todo.getTodoDescription() %></td>
  	     <td><%=todo.getTodoSdate() %></td>
  	     <td><%=todo.getTodoEdate() %></td>
  	     <td><a href="updateTodo.jsp?edit=<%=todo.getTodoId() %>">Edit</a></td>
  	     <td><a href="deleteTodo.jsp?delete=<%=todo.getTodoId()%>">Delete</a></td>
  	  </tr>
  
  </tbody>
  <%} %>
</table>
</div>









<!-- try block finishes below -->
<%}}catch(Exception e)
{
	e.printStackTrace();
}

%>





</body>
</html>