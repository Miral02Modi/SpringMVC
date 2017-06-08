package com.bridgeit.login.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.bridgeit.login.model.loginmodel;

public class Logindao {
	
	
	SessionFactory factory;

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	
	public void userRegister(loginmodel loginmodel){
		
		Session session = getFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(loginmodel);
		transaction.commit();
		session.close();
	}
	
	public List checkLogin(){
		Session session = getFactory().openSession();
		Query query = session.createQuery("from loginmodel");
		List<loginmodel> list = query.list();
		System.out.println(list);
		return list;
	}
}
