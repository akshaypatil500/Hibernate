package com.tca;

import com.tca.dao.StudentDao;
import com.tca.dao.StudentDaoImpl;
import com.tca.entities.Student;

public class App {

	public static void main(String[] args) {

		
		Student ob=new Student();
		ob.setRno(105);
		ob.setName("PPP");
		ob.setPer(89);
		
		StudentDao dao =new StudentDaoImpl();
		String status=dao.save(ob);
		
		if(status.equals("SUCCESS"))
		{
			System.out.println("Record is Saved Successfully");
		}
		else if(status.equals("FAILED"))
		{
			System.out.println("Record is not Saved Successfully...");
		}
		
	}

}
