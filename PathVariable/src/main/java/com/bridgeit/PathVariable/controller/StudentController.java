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
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.PathVariable.model.Student;
import com.bridgeit.PathVariable.service.StudentService;

@Controller
// @RequestMapping(value="/")
public class StudentController {
	@Autowired
	StudentService service;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields(new String[] { "email" });
		binder.registerCustomEditor(String.class, "name", new StudentNameEditor());
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Object addStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {

		System.out.println(student);
		if (bindingResult.hasErrors()) {
			System.out.println("Inside the error");
			ModelAndView andView = new ModelAndView("index");
			andView.addObject("Mobile", "It must be number");
			andView.addObject("name", "It must more than 1 words");
			return "Display";
		} else {
			service.getStudent();	
			return  service.addStudent(student);
		}

	}

	@ModelAttribute
	public void addToAllModel(Model model) {
		model.addAttribute("hello", "How are you");
		model.addAttribute("hi", "Miral");
		model.addAttribute("mobile", "must be number");
	}

}
