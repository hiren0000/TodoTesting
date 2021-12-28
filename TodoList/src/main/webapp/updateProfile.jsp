<%@page import="com.rebel.hiren.Beans.User"%>
<%@page import="com.rebel.hiren.Dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Profile</title>
<%@include file="common/css-js-common.jsp" %>
</head>
<body>
<%@include file="common/message.jsp" %>

<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies.
		
		User user = (User) session.getAttribute("user");
		
		if(user == null)
		{
			session.setAttribute("msg","Access Denied please login first!!");
			response.sendRedirect("welcome.jsp");
			
		}
		else{

		if(request.getParameter("edit") != null)
		{
			int id = Integer.parseInt(request.getParameter("edit"));
			
			UserDao dao = new UserDao();
		   	 user = dao.getUserById(id);
			
			%>
			
			
			
		
	 <!-- User Updating form -->
		 <div class="col-lg-6 offset-lg-3">
      
      	 <form action="update" method="post">
      	  
      	   
		   
		    <input type="hidden" class="form-control" name="uid" value="<%=user.getuId()  %>" >
		 
	      	      
	      <div class="form-group">
		    <label for="exampleInputEmail1">Name</label>
		    <input type="text" class="form-control" name="uName" value="<%=user.getuName() %>"  required="required">
		  </div>
		  
		  <div class="form-group">
		    <label for="exampleInputEmail1">Surname</label>
		    <input type="text" class="form-control" name="uSur" value="<%=user.getuSurname() %>" required="required">
		  </div>
		 
		  <div class="form-group">
		    <label for="exampleInputEmail1">Email</label>
		    <input type="email" class="form-control" name="uEmail" value="<%=user.getuEmail() %>" required="required">
		  </div>
		  
		  <div class="form-group">
		    <label for="exampleInputPassword1">Password</label>
		    <input type="password" class="form-control" name="uPass" value="<%=user.getuPass() %>" required="required">
		  </div>
		  
		  <div class="form-group">
            <button type="submit" name="updateUser" class="btn btn-primary">Update</button>
          </div>
    
        </form>
     
	  </div>
		





<%}}%>

</body>
</html>