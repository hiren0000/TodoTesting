package com.rebel.hiren.Activaton;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.rebel.hiren.Beans.User;
import com.rebel.hiren.Factory.FactoryProvider;

/**
 * Servlet implementation class AccountActivate
 */
public class AccountActivate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession  se = request.getSession();
		
		String email = request.getParameter("key1");
		String has = request.getParameter("key2");
		
		try {
			
			Session hbs = FactoryProvider.getFactory().openSession();
			Transaction tx = hbs.beginTransaction();
			
			Query<User> query = hbs.createQuery("from User U where U.uEmail = :email and U.hashPass = : has");
			query.setParameter("email", email);
			query.setParameter("has", has);
			
			User user = query.uniqueResult();
			tx.commit();
			hbs.close();
			
			if(user.getHashPass().equals(has) && user.getuEmail().equalsIgnoreCase(email))
			{
				se.setAttribute("msg", "your account is activated :)");
				response.sendRedirect("index.jsp");
			}else
			{
				se.setAttribute("msg" , "sorry unsuccessful registration ): ");
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println("prb with account acti serv");
		}
		
		
		
		
	}

}
