package com.bridgeit.PathVariable.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.PathVariable.model.Student;
import com.bridgeit.PathVariable.model.User;
import com.bridgeit.PathVariable.service.StudentService;
import com.bridgeit.PathVariable.service.UserService;

@Controller
public class StudentController {

	@Autowired
	StudentService service;
	@Autowired
	UserService userService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		/*
		 * binder.setDisallowedFields(new String[] { "email" }); It is used for
		 * disallow some field ignore from the form
		 */
		binder.registerCustomEditor(String.class, "name", new StudentNameEditor());
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public Object addStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
		System.out.println(student);
		/*
		 * System.out.println(student); if (bindingResult.hasErrors()) {
		 * System.out.println("Inside the error"); ModelAndView andView = new
		 * ModelAndView("index"); andView.addObject("Mobile",
		 * "It must be number"); andView.addObject("name",
		 * "It must more than 1 words"); return "Display"; }
		 */
		ModelAndView andView = new ModelAndView("redirect:/getData");
		service.addStudent(student);
		// andView.addObject("retrivedata", service.getStudent());
		return andView;

	}

	@RequestMapping(value = "getData")
	public ModelAndView getData() {
		ModelAndView andView = new ModelAndView("Display");
		andView.addObject("retrivedata", service.getStudent());
		andView.addObject("student", new Student());
		return andView;
	}

	public Student retriveData(int id) {
		System.out.println();
		Student student = service.retriveData(id);
		return student;
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public Object login() {
		/*
		 * StudentDaoImplement daoImplement = new StudentDaoImplement();
		 * daoImplement.isLoginValidate(student);
		 */
		return new ModelAndView("Login");
	}

	@RequestMapping(value = "registration", method = RequestMethod.POST)
	public Object register() {
		return "index";
	}

	@RequestMapping(value = "stdRegistration", method = RequestMethod.GET)
	public Object studentRegister() {
		return new ModelAndView("StudentRegister");
	}

	@RequestMapping(value = "validator", method = RequestMethod.POST)
	public Object isLoginValidator(@Valid @ModelAttribute("userForm") User user, BindingResult result) {

		if (userService.isValidUser(user)) {
			
			return new ModelAndView("redirect:/getData");
		}else{
			if (result.hasErrors()) {
				return "LoginUserValidation";
			}
			return new ModelAndView("LoginUserValidation", "userForm", new User());
		}
		

	}

	@RequestMapping(value = "userRegister", method = RequestMethod.POST)
	public Object userRegister(User user) {
		userService.userRegister(user);
		return new ModelAndView("Display");
	}

	@RequestMapping(value = "/")
	public ModelAndView landingPage() {
		ModelAndView andView = new ModelAndView("Student");
		return new ModelAndView("UserRegister");
	}

	@RequestMapping(value = "edit")
	public Object getEditForm(@RequestParam("id") int id) {
		System.out.println(id);
		Student student = retriveData(id);
		ModelAndView andView = new ModelAndView("UpdateStudent");
		andView.addObject("student", student);
		return andView;
	}

	@RequestMapping(value = "update")
	public Object updateData(Student student) {
		service.updateStudent(student);
		return new ModelAndView("redirect:/getData");
	}

	@RequestMapping(value = "delete")
	public Object deleteData(@RequestParam("id") int id) {
		service.deleteById(id);
		return new ModelAndView("redirect:/getData");
	}

	@ModelAttribute
	public void addToAllModel(Model model) {
		model.addAttribute("hello", "How are you");
		model.addAttribute("hi", "Miral");
		model.addAttribute("mobile", "must be number");
	}

}
