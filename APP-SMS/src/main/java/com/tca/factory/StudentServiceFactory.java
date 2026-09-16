package com.tca.factory;

import com.tca.service.StudentService;
import com.tca.service.StudentServiceImpl;

public class StudentServiceFactory {
	
	private static StudentService studentservice;
	
	private StudentServiceFactory() {};
	
	public static StudentService getStudentservice() {
		
		if(studentservice==null)
		{
			studentservice=new StudentServiceImpl();
		}
		
		return studentservice;
		
	}
	

}
