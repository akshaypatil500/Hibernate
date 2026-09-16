package com.tca.factory;

import com.tca.dao.StudentDao;
import com.tca.dao.StudentDaoImpl;

public class StudentDaoFactory {
	
	private static StudentDao studentdao;
	
	private StudentDaoFactory() {};
	
	public static StudentDao getstudentDao()
	{
		if(studentdao==null)
		{
		   studentdao=new StudentDaoImpl();
		}
		return studentdao;
	}

}
