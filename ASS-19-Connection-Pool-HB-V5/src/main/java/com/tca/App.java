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
		Session session = null;
		Transaction txn = null;

		try {
			configuration = new Configuration();
			configuration.configure();
			
			configuration.addAnnotatedClass(Student.class);

			sf = configuration.buildSessionFactory();
			session = sf.openSession();
			txn = session.beginTransaction();

//			Student ob = new Student();
//			ob.setRno(888);
//		ob.setName("AAA");
//		ob.setPer(67.0);
//			
			Student s=(Student)session.get(Student.class, 888);
			
			System.out.println("ROLL NO"+ s.getRno());
			System.out.println("NAME   "+ s.getName());
			System.out.println("PER    "+ s.getPer());

			
			//session.save(s);
			txn.commit();
			System.out.println("Data is Saved Successfully");

			
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
		} finally {

			session.close();
			sf.close();
		}

	}
}
