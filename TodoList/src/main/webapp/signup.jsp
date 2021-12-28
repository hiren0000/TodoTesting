<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
<%@include file ="common/css-js-common.jsp" %>
</head>
<body>

<!-- Register form -->
<form action="register" method="post" class="col-lg-6 offset-lg-3 ">
	<h2>Resgitration</h2>
	<%@include file="common/message.jsp" %>
	  <div class="form-group">
	    <label for="exampleInputEmail1">First Name</label>
	    <input type="text" class="form-control" name="uName"  placeholder="Enter Name" required="required">
	  </div>
	  
	  <div class="form-group">
	    <label for="exampleInputEmail1">Surname</label>
	    <input type="text" class="form-control" name="uSur" placeholder="Enter Surname" required="required">
	  </div>
	 
	  <div>
	    <label for="exampleInputEmail1">Email address</label>
	    <input type="email" class="form-control" name="uEmail" placeholder="Enter email" required="required">
	    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
	  </div>
	  
	  <div>
	    <label for="exampleInputPassword1">Password</label>
	    <input type="password" class="form-control" name="uPass" placeholder="Password" required="required">
	  </div>
	  <div> <button type="submit" class="btn btn-primary" name="sg-btn">SignUp</button></div>
	
</form>

</body>
</html>