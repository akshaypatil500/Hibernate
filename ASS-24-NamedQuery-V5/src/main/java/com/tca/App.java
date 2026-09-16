package com.tca;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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

        //----------------NAMED QUERY--------------------------
/*            
            Query query =session.getNamedQuery("GET_ALL_INFO");
            
            List<Student> list=query.list();
            
            for(Student s:list)
            {
         	   System.out.println("Roll Number "+s.getRno());
         	   System.out.println("Name        "+s.getName());
         	   System.out.println("Per         "+s.getPer());
         	   System.out.println("City        "+s.getCity());

         	   System.out.println("------------------------------------");
            }
            
          
            Query query =session.getNamedQuery("get_city_stud");
            query.setParameter("abc", "pune");
            
            List<Student> list=query.list();
            
            for(Student s:list)
            {
         	   System.out.println("Roll Number "+s.getRno());
         	   System.out.println("Name        "+s.getName());
         	   System.out.println("Per         "+s.getPer());
         	   System.out.println("City        "+s.getCity());

         	   System.out.println("------------------------------------");
            }

            
            //UPDATE
            
            Query query =session.createNamedQuery("update_city");
            query.setParameter("abc", "POONA");
            query.setParameter("pqr", "PUNE");
            
            int cnt=query.executeUpdate();
            System.err.println("No OF Records Updated"+cnt);
            

            
            //DELETE
            
            Query query =session.createNamedQuery("remove_student");
            query.setParameter("rollnumber", 104);
            
            
            int cnt=query.executeUpdate();
            System.err.println("No OF Records deleted"+cnt);
 */            
            Query query =session.getNamedQuery("findByCity");
          
            
            List<Student> list=query.list();
            
            for(Student s:list)
            {
         	   System.out.println("Roll Number "+s.getRno());
         	   System.out.println("Name        "+s.getName());
         	   System.out.println("Per         "+s.getPer());
         	   System.out.println("City        "+s.getCity());

         	   System.out.println("------------------------------------");
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