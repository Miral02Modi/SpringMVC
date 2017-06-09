package com.bridgeit.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.login.dao.Logindao;
import com.bridgeit.login.model.loginmodel;

@Controller
public class Login {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginDataSave(HttpServletRequest request, HttpServletResponse response) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
		Logindao logindao = (Logindao) applicationContext.getBean("logindao");

		loginmodel loginmodel = new loginmodel();

		String user = request.getParameter("email");
		String password = request.getParameter("password");
		loginmodel.setPassword(password);
		loginmodel.setUser(user);

		// logindao.userRegister(loginmodel);

		return new ModelAndView("display.jsp", "status", logindao.ischeckLogin(user, password));
	}

	@RequestMapping(value = "/dataCheck", method = RequestMethod.POST)
	public @ResponseBody String emailChecker(HttpServletRequest request, HttpServletResponse response) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
		Logindao logindao = (Logindao) applicationContext.getBean("logindao");
		return logindao.isDataAvailable(request, response);
	}

}
