package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entites.ContactNumber;
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

        //----------------Component Mapping--------------------------
            
        
//            ContactNumber contact=new ContactNumber();
//            contact.setCountryCode(91);
//            contact.setContact("1234333333");
            
     /*       Student s=new Student();
            s.setRno(101);
            s.setName("AAA");
            s.setCity("Pune");
            s.setPer(90.0);
            s.setContact(contact);
      */      
            Student s=(Student)session.get(Student.class, 101);
            
            System.out.println("ROll NUmber : " +s.getRno());
            System.out.println("Name        : "+s.getName());
            System.out.println("City        : "+s.getCity());
            System.out.println("PER         : "+s.getPer());
            System.out.println("Contact NUmber :+"+s.getContact().getCountryCode()+"-"+s.getContact().getContact());

            session.save(s);
            
           
       
            
        //----------------------------------------------------    
           
            
            txn.commit();
            System.out.println("Done");
            
        } catch (Exception e) {
            e.printStackTrace();
            txn.rollback();
        } finally {

            session.close();
            sf.close();
        }
    }
}