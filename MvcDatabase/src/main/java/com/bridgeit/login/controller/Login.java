package com.bridgeit.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.login.dao.Logindao;
import com.bridgeit.login.model.loginmodel;

@Controller
public class Login {

	@RequestMapping("/login")
	public String loginDataSave(HttpServletRequest request, HttpServletResponse response) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
		Logindao logindao = (Logindao) applicationContext.getBean("logindao");

		loginmodel loginmodel = new loginmodel();

		loginmodel.setPassword(request.getParameter("password"));
		loginmodel.setUser(request.getParameter("email"));
		

		logindao.userRegister(loginmodel);
		logindao.checkLogin();
		return "display.jsp";
	}
	
	
	
}
