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
			if(email != null && has != null)
			{
				Query<User> query = hbs.createQuery("from User U where U.uEmail = :email AND U.hashPass = : has");
				query.setParameter("email", email);
				query.setParameter("has", has);
				
				
				User user = query.uniqueResult();
				
				
				if(user != null )
				{
					
					Query<User> query2 = hbs.createQuery("UPDATE User set status = :status "+"Where uemail = :email");
					            query2.setParameter("status", 1);
					            query2.setParameter("email", email);
					            
				    int uQ = query2.executeUpdate();
			        System.out.println(" "+uQ);
			        
					 if(uQ == 1)
					 {
						 se.setAttribute("msg", "your account is activated :)");
						 response.sendRedirect("index.jsp");
					 }else
						{
							Query<User> query3 = hbs.createQuery("DELETE FROM User "+"Where uemail = :email");
				            
				            query3.setParameter("email", email);
				            
						    int s = query3.executeUpdate();
						    System.out.println(" "+s);
							se.setAttribute("msg" , "sorry unsuccessful registration ): ");
							response.sendRedirect("signup.jsp");
						}
			    }
			}
			tx.commit();
			hbs.close();
			
			
		} catch (Exception e) {
			System.out.println("prb with account acti serv"+e);
		}
		
		
		
		
	}

}
