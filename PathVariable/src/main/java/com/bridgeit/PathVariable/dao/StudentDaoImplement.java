package com.bridgeit.PathVariable.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.bridgeit.PathVariable.model.Student;

public class StudentDaoImplement implements StudentDao {

	@Autowired
	SessionFactory factory;
	
	
	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	public String addStudent(Student student) {
		
		System.out.println(student);
		Session session = getFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(student);
		transaction.commit();
		session.close();
		//ModelAndView andView = new ModelAndView("Display");
		return "Display";
	}

	

	public List<Student> getStudent() {
		Session session = getFactory().openSession();
		Query query=session.createQuery("from Student");  
		List<Student> list=query.list();  
		session.close();
		System.out.println(list);
		return list;
	}

	/*
	 * 
	 * public int deleteById(int id) {
	 * System.out.println("inside std dao implement"); return 0; }
	 * 
	 * public int deleteByName(String name) {
	 * System.out.println("inside std dao implement"); return 0; }
	 * 
	 * public void updateStudentDetails(Student student) throws Exception { //
	 * TODO Auto-generated method stub
	 * System.out.println("inside std dao implement"); }
	 * 
	 * public Student detailsOfStudent(int id) { // TODO Auto-generated method
	 * stub System.out.println("inside std dao implement"); return null; }
	 */

}
