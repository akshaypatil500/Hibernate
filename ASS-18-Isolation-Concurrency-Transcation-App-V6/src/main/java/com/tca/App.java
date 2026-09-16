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
		
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter Sender Account Number:");
		Integer senderAcno = Integer.parseInt(bf.readLine());

		System.out.println("Enter Receiver Account Number:");
		Integer receiverAcno = Integer.parseInt(bf.readLine());

		System.out.println("Enter Amount:");
		Double amount = Double.parseDouble(bf.readLine());
		
		Configuration configuration = null;
		SessionFactory sessiofactory = null;
		Session session = null;
		Transaction transcation = null;
	
		
//		Integer senderAcno=101;
//		Integer receiverAcno=102;
//		Double amount=5000.0;
//		

		try {
			configuration = new Configuration();
			configuration.configure();
			
			

			sessiofactory = configuration.buildSessionFactory();
			
			session = sessiofactory.openSession();
			
			
			Account  sob=session.get(Account.class,senderAcno);
			
			if(sob==null)
			{
				System.out.println("Invalid Sender Account NUmber"+senderAcno);
				return;
			}
			if(amount>=sob.getBalance())
			{
				System.out.println("InSufficient Balance in Receiver Account"+senderAcno);
				return;
			}
			
			sob.setBalance(sob.getBalance()-amount);
			
			
			Account rob=session.get(Account.class, receiverAcno);
			
			if(rob==null)
			{
				System.out.println("Invalid Sender Account NUmber"+receiverAcno);
				return;

			}
			rob.setBalance(rob.getBalance()+amount);
			
			
            
			
			transcation = session.beginTransaction();
			session.update(sob);
			session.update(rob);
			

			transcation.commit();
			System.out.println("Money Transfer Suddessfull");
			
	       

			
		} catch (Exception e) {
			
			transcation.rollback();
			e.printStackTrace();
			System.out.println("Money Transfer Failed");
			
		}
		finally {
			session.close();
			sessiofactory.close();
		}

	}
}
