package com.bridgeit.PathVariable.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bridgeit.PathVariable.dao.StudentDao;
import com.bridgeit.PathVariable.model.Student;

public class StudentServiceImplementation implements StudentService {

	@Autowired
	StudentDao studentDao;

	public Object addStudent(Student student) {

		return studentDao.addStudent(student);
		// return studentDao.addStudent(student);
		// return studentDao.addStudent(student);
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public List getStudent() {
		return studentDao.getStudent();
	}

	@Override
	public Object isLoginValidator(Student student) {
		return studentDao.isLoginValidator(student);
	}

	@Override
	public void deleteById(int id) {
		System.out.println("inside the service id");
		studentDao.deleteById(id);
	}

	@Override
	public void updateStudent(Student student) {
		studentDao.updateStudent(student);
	}

	@Override
	public Student retriveData(int id) {
		return studentDao.retriveData(id);
	}

	

	/*
	 * public List getStudent() { // TODO Auto-generated method stub
	 * studentDao.getStudent(); return null; }
	 * 
	 * public int deleteById(int id) { // TODO Auto-generated method stub
	 * studentDao.deleteById(id); return 0; }
	 * 
	 * public int deleteByName(String name) { // TODO Auto-generated method stub
	 * studentDao.deleteByName(name); return 0; }
	 * 
	 * public void updateStudentDetails(Student student) { // TODO
	 * Auto-generated method stub try {
	 * studentDao.updateStudentDetails(student); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 * 
	 * public Student detailsOfStudent(int id) { // TODO Auto-generated method
	 * stub studentDao.detailsOfStudent(id); return null; }
	 */

}
