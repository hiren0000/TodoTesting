<%@page import="com.rebel.hiren.Beans.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Verification</title>
<%@include file="common/css-js-common.jsp" %>
</head>
<body>

<%@include file="common/message.jsp" %>
<h1>Thank you,</h1>
<h3>please check your email and complete verification process</h3>

<%    User user = (User)session.getAttribute("newUser");
		
		if(user == null)
		{
			response.sendRedirect("signup.jsp");
			session.setAttribute("msg", "please fill the fields");
		}
		
		
		%>

	<form action="register" method="post" class="col-lg-6 offset-lg-3">
		
	  
	  <div class="form-group">
	   
	    <input type="hidden" class="form-control" name="email" value="<%=user.getuEmail() %>"  >
	  </div>
	  
	  	<input type="hidden" class="form-control" name="has" value="<%=user.getHashPass() %>" >
	  


	  <div> <button type="submit" class="btn btn-primary" name="ReSend">ReSend</button></div>
		
	</form>

</body>
</html>