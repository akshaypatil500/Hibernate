package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entites.Student;

public class App {
	public static void main(String[] args) {

		Configuration configuration = null;
		SessionFactory sf = null;
		Session s = null;
		Transaction txn = null;

		try {
			configuration = new Configuration();
			configuration.addAnnotatedClass(Student.class);
/*
			//Test Code -I want to Save The Record
			sf = configuration.buildSessionFactory();
			s = sf.openSession();
            txn = s.beginTransaction();

			Student s1 = new Student();
			s1.setRno(101);
			s1.setName("AAA");
			s1.setPer(56.7);
			s.save(s1);
*/
			
			sf = configuration.buildSessionFactory();
            s = sf.openSession();
            txn = s.beginTransaction();
            
            Student s1=s.get(Student.class, 101);
            Student s2=s.get(Student.class, 101);
            
            System.out.println(s1);
            System.out.println(s2);

            
			
			txn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
		} finally {

			s.close();
		}
	}
}
