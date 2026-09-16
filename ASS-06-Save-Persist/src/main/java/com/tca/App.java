package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entites.Student;
import com.tca.entites.Teacher;

public class App {
    public static void main(String[] args) {

    	Configuration configuration = new Configuration();
    	configuration.configure("mysqlconf.cfg.xml");
    	
    	Configuration configuration2 = new Configuration();
    	configuration2.configure("pgconf.cfg.xml");
    	
    	
    //------------------------------------------------------------------------------------
    	
    	
    	SessionFactory sf=configuration.buildSessionFactory();
    	Session session=sf.openSession();
    	Transaction txn =session.beginTransaction();
    	
    	SessionFactory sf2=configuration2.buildSessionFactory();
    	Session session2=sf2.openSession();
    	Transaction txn2 =session2.beginTransaction();
    	
    	
    	
    	Student ob=new Student();
    	ob.setRno(101);
    	ob.setName("AAA");
    	ob.setPer(60.0);
    	session.persist(ob);
    	session2.persist(ob);

    	
    	Teacher teacher=new Teacher();
    	teacher.setTno(201);
    	teacher.setTname("Sachin");
    	teacher.setSalary(400000.0);
    	
        session.persist(teacher);
        session2.persist(teacher);

    	 
         txn.commit();
         txn2.commit();
    
         session.close();
         session2.close();
         sf.close();
         sf2.close();
    	System.out.println("Data is Saved Successfully");
        
    }
}
