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
 * Servlet implementation class UpdateUser
 */
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
     UserDao udao = new UserDao();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession htse = request.getSession();
		
		int id = Integer.parseInt(request.getParameter("uid"));
		String uname = request.getParameter("uName");
		String usur = request.getParameter("uSur");
		String upass = request.getParameter("uPass");
		String uemail = request.getParameter("uEmail");
		String hashmake = request.getParameter("has");
		int st = Integer.parseInt(request.getParameter("st"));
		
		String newPass = DigestUtils.md5Hex(upass);
		
		User existingUser = new User(id, uname, usur, uemail, newPass, hashmake);
		     existingUser.setStatus(st);
		try {
			
			udao.updateUser(existingUser);
			htse.setAttribute("msg", "Data has been updated successfully :)");
			response.sendRedirect("index.jsp");
			
		} catch (Exception e) {
			System.out.println("sm prb wid update servlet ): "+e);
		}
	}
		
		
}


