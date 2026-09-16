package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Student;

public class App {
	public static void main(String[] args) {

		Configuration configuration = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction txn = null;

		try {
			configuration = new Configuration();

			configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
			configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hfb02");
			configuration.setProperty("hibernate.connection.username", "root");
			configuration.setProperty("hibernate.connection.password", "akki");
			configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
			configuration.setProperty("hibernate.hbm2ddl.auto", "update");
			configuration.setProperty("hibernate.show_sql", "create");

			configuration.addResource("Student.hbm.xml");

			sf = configuration.buildSessionFactory();
			session = sf.openSession();

			txn = session.beginTransaction();

			Student s = new Student();
			s.setRno(333);
			s.setName("Boss");
			s.setPer(90);

			session.save(s);
			txn.commit();
			System.out.println("Successfully");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			sf.close();
			session.close();
		}

	}
}
