package com.rebel.hiren.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.rebel.hiren.Beans.User;
import com.rebel.hiren.Factory.FactoryProvider;
import com.rebel.hiren.Mail.SendMail;

public class UserDao 
{
	
	
	public UserDao() {}
	
	//Saving new user Data
	public boolean saveUser(User user)
	{
		 
		try {
			
			Session HibSes = FactoryProvider.getFactory().openSession();
			Transaction tx = HibSes.beginTransaction();
			
			Query<User> query = HibSes.createQuery("from User U where U.uEmail = :email");
			query.setParameter("email",  user.getuEmail());
			User ExUser = query.uniqueResult();
			
			if(ExUser == null)
			{
				HibSes.save(user);
			
				
//				sending data to send verifiy email address
				SendMail mail = new SendMail(user.getuEmail(), user.getHashPass());
				mail.sendMail();
				return true;
			}
			tx.commit();
			HibSes.close();
				
		} catch (Exception e) {
			System.out.println("sm prb wid saving object ):" +e);
		}
		
		return false;
	}
	
	
	//fetching useremail and password
	public User getUserEmailandPass(String email, String pass)
	{
		
		
		User user = null;
		
		try {
			Session HibSe = FactoryProvider.getFactory().openSession();
			Transaction tx = HibSe.beginTransaction();
			
			Query<User> query = HibSe.createQuery("from User U where U.uEmail = :email and U.uPass = :pass");
			query.setParameter("pass", pass);
			query.setParameter("email", email);
			
			user = query.uniqueResult();
		   
			if(user != null)
			
			{
				if(user.getStatus() == 0)
				{
					
					Query<User> query3 = HibSe.createQuery("DELETE FROM User "+"Where uemail = :email");
		            
		            query3.setParameter("email", email);
		            
				    int s = query3.executeUpdate();
				    System.out.println(" "+s);
					
					return null;
					
				}
			}
				
				tx.commit();
				HibSe.close();			
			
		} catch (Exception e) {
			System.out.println("sm prb wid fetching data for login ):" +e);
		}
		
		
		return user;
		
		
	}
	
	//forgot Password 
	public User forgotPass(String email)
	{
				
		User user = null;
		
		try {
			Session HibSe = FactoryProvider.getFactory().openSession();
			Transaction tx = HibSe.beginTransaction();
			
			Query<User> query = HibSe.createQuery("from User U where U.uEmail = :email");
			query.setParameter("email", email);
						
			 user = query.uniqueResult();
		
			tx.commit();
			HibSe.close();
			
			if(user != null)
			{//sending email 
			SendMail mail2 = new SendMail(user.getuEmail(), user.getuId());
			mail2.forgotPassword();
			
			}
			
		} catch (Exception e) {
			System.out.println("sm prb wid fetching data for forgeting password ):" +e);
		}
		
		
		return user;
			
	}
	
	//fetching userinfo by userId
	public User getUserById(int id)
	{
		User user = null;
		try {
			Session HibSe = FactoryProvider.getFactory().openSession();
			Transaction tx = HibSe.beginTransaction();
			
			user = HibSe.get(User.class, id);
			
			tx.commit();
			HibSe.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("sm prb wid updating user code ):"+e);
		}
		
		
		
		return user;
	}
	
	//update User data 
	public User updateUser(User user)
	{
		
		try {
			Session HibSe = FactoryProvider.getFactory().openSession();
			Transaction tx = HibSe.beginTransaction();
			
			HibSe.update(user);
			
			tx.commit();
			HibSe.close();
						
		} catch (Exception e) {
			System.out.println("sm prb wid updating object ):"+e);
		}
		
		return user;
	}
	
	
	//update user specific field
	public void updatePassById(int id, String pass)
	{
		User user = null;
		
		try {
			 Session se = FactoryProvider.getFactory().openSession();
			 Transaction tx = se.beginTransaction();
			 
			 //getting the value of user
			 user = se.get(User.class, id);
			 
			 //updating only pass value
			 user.setuPass(pass);
			 se.update(user);
			
			 tx.commit();
			 se.close();
			
			
		} catch (Exception e) {
			System.out.println("sm prb wid dao using forgot pass ): "+e);
			e.printStackTrace();
		}
		
	}
	
	//Delete User by userId
	public void deleteUser(int id)
	{
		User user = null;
		
		try {
			 Session se = FactoryProvider.getFactory().openSession();
			 Transaction tx = se.beginTransaction();
			 
			 user = se.get(User.class, id);
			 se.delete(user);
			 
			 tx.commit();
			 se.close();
			
			
		} catch (Exception e) {
			System.out.println("sm prb wid deleting user account ): "+e);
		}
		
		
		
	}
	
}
