package com.rebel.hiren.Factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rebel.hiren.Beans.Todo;
import com.rebel.hiren.Beans.User;

public class FactoryProvider 
{
	private static SessionFactory factory;
	
	public static SessionFactory getFactory()
	{
		try {
			if(factory == null)
			{
				Configuration con = new Configuration().configure();
				factory = con.buildSessionFactory();
			}
			
			
		} catch (Exception e) {
			System.out.println("Factory creation is failed ): " + e);
		}
		
		
		return factory;
	}

}
