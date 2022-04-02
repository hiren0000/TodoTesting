<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Password</title>
<%@include file="common/css-js-common.jsp" %>
</head>
<body>
<%@include file="common/message.jsp" %>

<%

		try{
			
			
		
		if(request.getParameter("key1") != null)
		{
			
			int uId = Integer.parseInt(request.getParameter("key1"));
			
	
%>

<!-- Change Password form -->
<form action="login" method="post" class="col-lg-6 offset-lg-3">
	
	<h2>Change Password</h2>
	
	  <div><input type="hidden" name="uid" value="<%=uId%>"></div>
	  
	  <div class="form-group">
	    <label for="exampleInputEmail1">New Password</label>
	    <input type="password" class="form-control" name="upass"  placeholder="Enter New Password" required="required">
	  </div>
	  
	   
	  	  
	  <div> <button type="submit" class="btn btn-primary" name="changePass">Update</button></div>
     
   </form>


<%

		}
		
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}





%>


</body>
</html>