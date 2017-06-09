package com.bridgeit.login.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.login.model.loginmodel;

@Controller
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

	@Transactional
	@RequestMapping(value = "/dataCheck", method = RequestMethod.POST)
	public @ResponseBody String isDataAvailable(HttpServletRequest request, HttpServletResponse response) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
		Logindao logindao = (Logindao) applicationContext.getBean("logindao");
		Session session = logindao.getFactory().openSession();
		Query query = session.createQuery("from loginmodel where user=:id");
		query.setParameter("id", request.getParameter("email"));
		List list = query.list();
		
		
		if(list.size() == 0){
			return "0";
		}else
			return  "1";
	}
}
