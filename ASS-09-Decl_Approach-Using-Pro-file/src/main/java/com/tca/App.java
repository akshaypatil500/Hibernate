package com.tca;

import java.io.FileInputStream;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Student;

public class App {
	public static void main(String[] args) {
	
	 Configuration configuration =null;
	 SessionFactory sf =null;
	 Session session=null;
	 Transaction txn=null;
	 
	 try
	 {
		 configuration=new Configuration();    // This will Search for 'hibernate.Properties'
		 configuration.addResource("Student.hbm.xml");

		/* 
		 FileInputStream fils=new FileInputStream("src/main/resources/hibernate.properties");
		 Properties prop=new Properties();                                                    //
		 prop.load(fils);                            // User Define Property File
		  configuration.addResource("Student.hbm.xml");
		*/
		 
		 
		 sf=configuration.buildSessionFactory();
		 session=sf.openSession();
		 
		 txn=session.beginTransaction();
		 
		 Student s=new Student();
		 s.setRno(102);
		 s.setName("Akki");
		 s.setPer(89);
		
		 session.save(s);
		 txn.commit();
		 System.out.println("Successfully");
		 
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
