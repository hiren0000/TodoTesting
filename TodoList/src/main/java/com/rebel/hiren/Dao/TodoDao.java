package com.rebel.hiren.Dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.rebel.hiren.Beans.Todo;
import com.rebel.hiren.Factory.FactoryProvider;

public class TodoDao 
{
	//Sava data object 
	public void saveTodo(Todo todo)
	{
		try {
			
			Session HibSe = FactoryProvider.getFactory().openSession();
			Transaction tx = HibSe.beginTransaction();
			
			HibSe.save(todo);
			
			tx.commit();
			HibSe.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("sm prb wid todo creation "+ e);
		}
		
		
		
	}
	
	//getting all the Todos
	public List<Todo> getAllTodo(int userId)
	{
		List<Todo> todo = null;
		
		try {
			Session HibSe = FactoryProvider.getFactory().openSession();
			Transaction tx = HibSe.beginTransaction();
			
			Query<Todo> query = HibSe.createQuery("from Todo as T where T.user.uId = :userId ");
			query.setParameter("userId", userId);
			todo = query.list();
			
			tx.commit();
			HibSe.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("sm prb with getting todo object" + e);
		}
		
		
		
		return todo;
		
	}
	
	//get todo by todoId
	public Todo getTodoById(int tid)
	{
		Todo todo = null;
		try {
			 Session hibSe = FactoryProvider.getFactory().openSession();
			 Transaction tx = hibSe.beginTransaction();
			 
			 todo = hibSe.get(Todo.class, tid);
			 
			 tx.commit();
			 hibSe.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("sm prb wid fetching todo by id"+ e);
		}
		
		
		return todo;
		
	}
	
	
	//update todo object 
		public void updateTodo(Todo todo)
		{
			try {
				
				Session HibSe = FactoryProvider.getFactory().openSession();
				Transaction tx = HibSe.beginTransaction();
				
				HibSe.update(todo);
				
				tx.commit();
				HibSe.close();
				
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("sm prb wid todo updation "+ e);
			}
		}

		
		//Delete record by todoId
		public void deleteTodo(int id)
		{
			Todo todo = null;
			
	   try {
				
				Session HibSe = FactoryProvider.getFactory().openSession();
				Transaction tx = HibSe.beginTransaction();
				
				todo = HibSe.get(Todo.class, id);
				
				HibSe.remove(todo);
				
				tx.commit();
				HibSe.close();
				
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("sm prb wid todo deletation "+ e);
			}
			
		}
}
