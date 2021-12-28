<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
<%@include file="common/css-js-common.jsp" %>

</head>
<body>


	<form action="login" method="post" class="col-lg-6 offset-lg-3">
		
	  <h2>Confirm Email</h2><br><br>
	  <div class="form-group">
	    <label for="exampleInputEmail1">UserEmail</label>
	    <input type="email" class="form-control" name="uemail"  placeholder="Enter Email" required="required">
	  </div>


	  <div> <button type="submit" class="btn btn-primary" name="forgotButton">Submit</button></div>
		
	</form>


</body>
</html>