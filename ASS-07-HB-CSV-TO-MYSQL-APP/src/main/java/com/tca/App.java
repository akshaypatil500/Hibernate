package com.tca;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
			configuration.configure();

			sf = configuration.buildSessionFactory();
			session = sf.openSession();
			txn = session.beginTransaction();
			BufferedReader br = new BufferedReader(
				    new InputStreamReader(
				        App.class.getClassLoader().getResourceAsStream("student_CSV.csv")
				    )
				);
		//	BufferedReader br=new BufferedReader(new InputStreamReader(null, "src/main/resources/student_CSV.csv"));


			String line;

			int i = 0;

			while ((line = br.readLine()) != null) {

				String[] data = line.split(",");

				Student s = new Student();
				s.setRno(Integer.parseInt(data[0]));
				s.setName(data[1]);
				s.setPer(Double.parseDouble(data[2]));

				session.save(s);

				// ✅ Batch processing
				if (i % 20 == 0) {
					session.flush();
					session.clear();
				}
				i++;
			}

			br.close();

			txn.commit();
			System.out.println("CSV Data Inserted Successfully");

		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();

		} finally {
			session.close();
			sf.close();
		}
	}
}	

