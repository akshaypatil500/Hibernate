package com.tca.service;

import java.util.List;
import java.util.Scanner;

import com.tca.dao.StudentDao;
import com.tca.entites.Student;
import com.tca.factory.StudentDaoFactory;

public class StudentServiceImpl implements StudentService {

	@Override
	public Integer addStudent(Student student) {
		
		StudentDao dao =StudentDaoFactory.getstudentDao();
		
		student.setName(student.getName().toLowerCase());
		student.setCity(student.getCity().toLowerCase());
		
		Integer id=dao.saveStudent(student);
		return id;
	}

	@Override
	public Student fetchStudentById(Integer id) {
		
		StudentDao dao =StudentDaoFactory.getstudentDao();
        Student s=dao.findStudentById(id);
        
        if(s!=null)
        {
        	s.setName(s.getName().toUpperCase());
        	s.setCity(s.getCity().toUpperCase());
        }
		return s;
	}

	@Override
	public List<Student> fetchStudentByName(String name) {
		
		StudentDao dao =StudentDaoFactory.getstudentDao();

		//List<Student> studentlist=dao.fetchStudentByName(name); //Either write this
		 return dao.fetchStudentByName(name.toLowerCase());      // Or this Both Are Same
	}

	@Override
	public List<Student> fetchStudentByCity(String city) {

		StudentDao dao =StudentDaoFactory.getstudentDao();
		
		List<Student> studentList =dao.fetchStudentByCity(city);
		
		return studentList;

		
	}

	@Override
	public boolean modifyStudent(Integer id) {
		
		StudentDao dao =StudentDaoFactory.getstudentDao();
		
		Student s=dao.findStudentById(id);
		
		if(s==null)
		{
			return false;
		}
		else
		{
			Scanner sc=new Scanner(System.in);
			
			
			System.out.print("[Old Name : "+s.getName() +"] Enter New Name :");
			s.setName(sc.nextLine());
			
			System.out.print("[Old Percentage : "+s.getPer() +"] Enter New Percentage :");
			s.setPer(sc.nextDouble());
			
			System.out.print("[Old City : "+s.getCity() +"] Enter New City :");
			s.setCity(sc.next());
			
			boolean status =dao.updateStudent(s);
			return status;


			
		}

		
	}

	@Override
	public boolean removeStudent(Integer id) {
		
	   StudentDao dao=StudentDaoFactory.getstudentDao();
	   Student s=dao.findStudentById(id);
	   if(s==null)
	   {
		   return false;
	   }
	   else
	   {
	    boolean status =dao.deleteStudent(s);
	    return status;
	   }
	}

	

}
