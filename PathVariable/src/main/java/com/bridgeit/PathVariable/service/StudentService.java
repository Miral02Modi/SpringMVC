package com.bridgeit.PathVariable.service;

import java.util.List;

import com.bridgeit.PathVariable.model.Student;

public interface StudentService {
	
	public Object addStudent(Student student);
		
	public List getStudent();
	
	/*public int deleteById(int id);
	
	public int deleteByName(String name);
	
	public void updateStudentDetails(Student student);
	
	public Student detailsOfStudent(int id);*/
}
