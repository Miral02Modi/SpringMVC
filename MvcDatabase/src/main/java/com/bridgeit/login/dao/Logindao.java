package com.bridgeit.login.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

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

	@Transactional
	public void userRegister(loginmodel loginmodel) {

		Session session = getFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(loginmodel);
		transaction.commit();
		session.close();
	}

	@Transactional
	public boolean ischeckLogin(String user, String password) {
		Session session = getFactory().openSession();
		Query query = session.createQuery("from loginmodel where user=:id and password=:pass");
		// List<loginmodel> list = query.list();
		// System.out.println(list);
		query.setParameter("id", user);
		query.setParameter("pass", password);
		List list = query.list();
		session.close();
		return list.size() != 0;
	}

	public  String isDataAvailable(HttpServletRequest request, HttpServletResponse response) {
		
		Session session = getFactory().openSession();
		Query query = session.createQuery("from loginmodel where user=:id");
		query.setParameter("id", request.getParameter("email"));
		List list = query.list();
		
		if(list.size() == 0){
			return "0";
		}else
			return  "1";
	}
}
