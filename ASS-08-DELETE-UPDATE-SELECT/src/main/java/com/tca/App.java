package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Student;

public class App {
	public static void main(String[] args) {
	
	 Configuration configuration =null;
	 SessionFactory sf =null;
	 Session session=null;
	 
	 try
	 {
		 configuration=new Configuration();
		 configuration.configure();  
		 
		 sf=configuration.buildSessionFactory();
		 session=sf.openSession();
		 
		/* public SessionFactory buildSessionFactory // कारण त्या method चं काम Configuration return करणं नाही
                                                         तर SessionFactory create करून देणं आहे
		 {
			 return SessionFactoryImpl();
		 }
		 */
		 
		 //Class c = Student.class;
		 //Reflection
		  Student s= (Student) session.get(Student.class, 102);    //get()
		 // Student s= (Student) session.load(Student.class, 102); //load()

		  
		  System.out.println("Roll Number :"+ s.getRno() );
		  System.out.println("Name        :"+ s.getName());
		  System.out.println("Percentage  :"+ s.getPer());

	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
		 
	 }
	 finally
	 {
		 sf.close();
		 session.close();
	 }
			 
	}
}
