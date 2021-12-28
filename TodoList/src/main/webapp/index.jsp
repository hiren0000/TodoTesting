<html>
<title>Home</title>

<%@include file="common/css-js-common.jsp" %>
<body>

<%@include file="common/message.jsp" %>

<h2 style="align-content: center">Welcome to the TodoList</h2>



<br><br>

<!-- LogIn form -->

	<form action="login" method="post" class="col-lg-6 offset-lg-3">
	
	<h2>LogIn</h2>
	  <div class="form-group">
	    <label for="exampleInputEmail1">UserEmail</label>
	    <input type="email" class="form-control" name="uemail"  placeholder="Enter Email" required="required">
	  </div>
	  
	  <div class="form-group">
	    <label for="exampleInputEmail1">Password</label>
	    <input type="password" class="form-control" name="uPass" placeholder="Enter Password" required="required">
	  </div>
	  
	  <div class="form-group">
	    <a href="forgotPassword.jsp">forgot Password?</a>
	  
	  </div>
	  
	  
	  <div> <button type="submit" class="btn btn-primary" name="loginButton">SignIn</button></div>
      <div><a href="signup.jsp">If you are not registered, Please register here..</a></div>
   </form>





	
	
	
	
	
	
	
	
	
	
	
	
	
	


</body>
</html>
