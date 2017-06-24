package com.bridgeit.PathVariable.dao;

import java.util.List;

import com.bridgeit.PathVariable.model.Student;

public interface StudentDao {
	
	public Object addStudent(Student student);

	public List getStudent();

	/*public int deleteById(int id);

	public int deleteByName(String name);

	public void updateStudentDetails(Student student) throws Exception;

	public Student detailsOfStudent(int id);*/
	
}
