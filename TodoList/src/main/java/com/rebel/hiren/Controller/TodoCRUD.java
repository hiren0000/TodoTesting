package com.rebel.hiren.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rebel.hiren.Beans.Todo;
import com.rebel.hiren.Beans.User;
import com.rebel.hiren.Dao.TodoDao;

/**
 * Servlet implementation class TodoCRUD
 */
public class TodoCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession userSe = request.getSession();
		
		User user = (User)userSe.getAttribute("user");
		
		
		if(request.getParameter("newTodo") != null)
			
		  {
				HttpSession htSe = request.getSession();
				
				String tname =  request.getParameter("tName");
				String tdes =  request.getParameter("tDes");
				String tsdate =  request.getParameter("tSdate");
				String tedate =  request.getParameter("tEdate");
				
				
				Todo todo = new Todo(tname, tdes, tsdate, tedate);
				     todo.setUser(user);
				
				try {
					
					TodoDao tdao = new TodoDao();
					tdao.saveTodo(todo);
					
					htSe.setAttribute("msg", "You have successfully added Todo :)");
					response.sendRedirect("welcome.jsp");
					
					
				} catch (Exception e) {
					
					System.out.println("sm prb wid todo Controller ): ");
				}
				
		  }
		
		  // this code will work for the update todo
		  else if(request.getParameter("updateTodo") != null)
		  {
			  
			  HttpSession httSe = request.getSession();
				
			    int id = Integer.parseInt(request.getParameter("tId"));
				String tname =  request.getParameter("tName");
				String tdes =  request.getParameter("tDes");
				String tsdate =  request.getParameter("tSdate");
				String tedate =  request.getParameter("tEdate");
				
				
				Todo todo = new Todo(id, tname, tdes, tsdate, tedate);
					 todo.setUser(user);
				
				try {
					
					TodoDao tdao = new TodoDao();
					tdao.updateTodo(todo);
					
					httSe.setAttribute("msg", "your todo is successfully updated :)");
					response.sendRedirect("welcome.jsp");
					
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("sm prb wid todo Controller in updation part ): "+e);
				}
				
			  
			  
			  
			  
		  }
		
	}

}
