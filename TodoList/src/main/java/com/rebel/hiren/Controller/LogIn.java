package com.rebel.hiren.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import com.rebel.hiren.Beans.User;
import com.rebel.hiren.Dao.UserDao;

/**
 * Servlet implementation class LogIn
 */
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession se = request.getSession();
		PrintWriter out = response.getWriter();
		
		User user = new User();
		
	try {
		
				
			if(request.getParameter("loginButton") != null)
				
			{
					
				String email = request.getParameter("uemail");
				String pass = request.getParameter("uPass");
				
				String haspass = DigestUtils.md5Hex(pass);
					
					UserDao dao = new UserDao();
					
					    user = dao.getUserEmailandPass(email, haspass);	
					
					
					   if(user == null)
					   {   
						   se.setAttribute("msg", "Invalid data !! ): ");
						   response.sendRedirect("index.jsp");
						
					   }
					   else{
						  
						   se.setAttribute("user", user);
						   response.sendRedirect("welcome.jsp");
					   }
			 }	 
	
		
		else if(request.getParameter("forgotButton") != null)
				
			{
			    String email = request.getParameter("uemail");
			    
			    UserDao dao = new UserDao();
			    
			    user = dao.forgotPass(email);
			    
			    if(user == null)
				   {   
					   se.setAttribute("msg", "Invalid email !! ): ");
					   response.sendRedirect("index.jsp");
					
				   }
				   else{
					   se.setAttribute("msg", "Please check your email !! :) ");
					   response.sendRedirect("index.jsp");
				   }


				
			}
			
		else if(request.getParameter("changePass") != null)
		   {
			  
				int uId = Integer.parseInt(request.getParameter("uid"));
			    String upass = request.getParameter("upass");
			
			    String hashPass = DigestUtils.md5Hex(upass);
			    
			   
			    UserDao dao = new UserDao();
			    dao.updatePassById(uId, hashPass);
			    
			    out.print("yeah u have successfully changed Pass");
				   

			    
			
		   }
						   
				  
				
		} catch (Exception e) {
		  System.out.println("sm prb with login serv"+e);
		  e.printStackTrace();
		}
	}

}
