package com.bridgeit.PathVariable.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.bridgeit.PathVariable.model.User;

public class UserDaoImpl implements UserDao {
	
	
	@Autowired
	SessionFactory factory;

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	
	
	@Override
	public boolean isValidUser(User user) {
		
		
		Session session = getFactory().openSession();
		Query query = session.createQuery("select password from User where email=:id and password=:pass");
		
		
		query.setParameter("id", user.getEmail());
		query.setParameter("pass", user.getPassword());
		
		List<Object> list = query.list();
		
		
		for(Object row :list){
			
			String password = (String) row;
			
			if(password.isEmpty())
			{
				System.out.println("Email is incorrect");
				return false;
			}
			
			if(password.equals(user.getPassword()))
				return true;
			else{
				System.out.println("Password is Wrong");
				return false;
			}
		}
		return false;
	}

	@Override
	public void userRegister(User user) {
		Session session = getFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
	}
	

}
