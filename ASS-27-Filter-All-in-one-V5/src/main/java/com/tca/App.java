package com.tca;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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

        //----------------Filter--------------------------
            
            //Filter=1
   
 /*           Filter filter=session.enableFilter("cityfilter");
              filter.setParameter("tca", "delhi");
         
         
           // Filter 2
            Filter filter=session.enableFilter("perfilter");
            filter.setParameter("pqr", 70.0);
           
 */  
            Filter filter=session.enableFilter("percityfilter");
            filter.setParameter("lmn", "delhi");
            filter.setParameter("xyz", 60.0);
            Query query=session.createQuery("from Student");
            
            session.disableFilter("percityfilter");
            List<Student> list=query.list();
            if (list.isEmpty())
            {
            	System.out.println("Records not found");
            }
  
            else	
            {
            	 for(Student s:list)
                 {
              	   System.out.println("Roll Number "+s.getRno());
              	   System.out.println("Name        "+s.getName());
              	   System.out.println("Per         "+s.getPer());
              	   System.out.println("City        "+s.getCity());

              	   System.out.println("------------------------------------");
                 }
            }
           
       
            
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