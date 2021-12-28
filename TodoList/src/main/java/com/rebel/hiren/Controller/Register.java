package com.rebel.hiren.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import com.rebel.hiren.Beans.User;
import com.rebel.hiren.Dao.UserDao;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao udao = new UserDao();   
    

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession htse = request.getSession();
		
	
		String uname = request.getParameter("uName");
		String usur = request.getParameter("uSur");
		String upass = request.getParameter("uPass");
		String uemail = request.getParameter("uEmail");
		
		
		String newPass = DigestUtils.md5Hex(upass);
		
		String hashmake;
		Random rd = new Random();
		rd.nextInt(999999);
		hashmake = DigestUtils.md5Hex(""+rd);
		
		User newUser = new User(uname, usur, uemail, newPass, hashmake);
		
		try {
			
			udao.saveUser(newUser);
			htse.setAttribute("msg", "Data has been saved successfully :)");
			response.sendRedirect("verify.jsp");
			
		} catch (Exception e) {
			System.out.println("sm prb wid register servlet ): ");
		}
	}

	

}
