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
		Session session = getFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(student);
		transaction.commit();
		session.close();
		// ModelAndView andView = new ModelAndView("Display");
		return "Display";
	}

	public List<Student> getStudent() {
		Session session = getFactory().openSession();
		Query query = session.createQuery("from Student");
		List<Student> list = query.list();
		session.close();
		if (list.size() != 0)
			return list;
		return null;
	}

	public Object isLoginValidator(Student student) {

		Session session = getFactory().openSession();
		Query query = session
				.createQuery("select name , mobileNumber from Student where email =:id and password =:pass");
		query.setParameter("id", student.getEmail());
		query.setParameter("pass", student.getPassword());
		List<Object[]> list = query.list();
		System.out.println(list);
		for (Object[] row : list) {
			System.out.println("name" + row[0]);
			System.out.println("Mobile" + row[1]);
		}

		if (list == null)
			return "index";
		else
			return "Display";
	}

	/* Delete student information by their id */
	@Override
	public void deleteById(int id) {
		System.out.println("inside the delete" + id);
		Session session = getFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query qry = session.createQuery("delete from Student where id=:sid");
		qry.setParameter("sid",id);
		int res = qry.executeUpdate();
		session.close();
	}

	/* update the student information by their Id */
	public void updateStudent(Student student) {

		Session session = getFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(student);
		transaction.commit();
		System.out.println("Object Updated successfully.....!!");
		session.close();

	}

	@Override
	public Student retriveData(int sid) {

		System.out.println("inside the std_dao");
		Session session = getFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Student where id =:sid");
		query.setParameter("sid", sid);
		List<Student> list = query.list();
		System.out.println(list);
		Student student = list.get(0);

		return student;
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
