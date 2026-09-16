package com.tca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tca.entites.Course;
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

           
            sf = configuration.buildSessionFactory();
            session = sf.openSession();
            txn = session.beginTransaction();

        //----------------MANY-TO-MANY-Association Mapping--------------------------
            
            //Assignment
            // Find Student-Course Information Whose registration take place on 21 may
            
            // Write This by using Native SQL
            
/*
           LocalDate d=LocalDate.of(2026, 5, 21);
           
           String sql="  select s.name,c.cname,sc.reg_date " + 
                      "    from studentcourse sc "  +
        		      "   join student s on s.rno=sc.fk_rno "  +
        		      "  join course c  on c.cid=sc.fk_cid " +
        		      "  WHERE sc.reg_date =:date ";
           
           Query query =session.createNativeQuery(sql);
           
           query.setParameter("date", d);
           
           List<Object[]> result=query.getResultList();
           
           for(Object[] rec: result)
           {
        	   System.out.println(rec[0]+" Registered for "+ rec[1]);
           }
*/
            
            // Write This by using HQL
            
//            Scanner sc=new Scanner(System.in);
//            System.out.println("Enter the date");
//            String date=sc.next();
//            LocalDate d=LocalDate.parse(date);
             // OR
             // LocalDate d=LocalDate.parse(sc.next());
            
            BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter date (yyyy-mm-dd)");
            LocalDate d =LocalDate.parse(bf.readLine());
            
            String hql=  " select sc.student,sc.course " +
            		     " from StudentCourse sc " +
            		     " where sc.reg_date=:date" ;	
            
            Query query=session.createQuery(hql);
            query.setParameter("date", d);
            
            List<Object[]> result=query.getResultList();
            
            for(Object[] rec:result)
            {
            	Student s=(Student)rec[0];
            	Course c=(Course)rec[1];
            	
         	   System.out.println(s.getName()+" Registered for "+ c.getCname());

            	
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