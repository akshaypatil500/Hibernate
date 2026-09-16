package com.tca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entites.Account;

public class App {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Configuration configuration = null;
		SessionFactory sessiofactory = null;
		Session session1 = null;
		Transaction transcation1 = null;
		Session session2 = null;
		Transaction transcation2 = null;
		


		try {
			configuration = new Configuration();
			configuration.configure();
			
			

			sessiofactory = configuration.buildSessionFactory();
			
			session1 = sessiofactory.openSession();
			transcation1=session1.beginTransaction();

			Account a1=session1.get(Account.class, 101);
			a1.setBalance(a1.getBalance()+15);
			
		
			
			session2 = sessiofactory.openSession();
			transcation2=session2.beginTransaction();
			Account a2=session2.get(Account.class, 101);
			a2.setBalance(a2.getBalance()-25);
			
			session1.update(a1);
			session2.update(a2);
			transcation1.commit();
			transcation2.commit();
	       
			System.out.println("Suddessfulll...");

			
		} catch (Exception e) {
			
			transcation1.rollback();
			transcation2.rollback();

			e.printStackTrace();
			System.out.println("Money Transfer Failed");
			
		}
		finally {
			session1.close();
			session2.close();

			sessiofactory.close();
		}

	}
}
