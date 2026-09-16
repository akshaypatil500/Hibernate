package com.tca;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SQLQuery;
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

        //----------------Native SQL--------------------------
            
          
            
/*         SQLQuery sqlquery=session.createSQLQuery("select * from student");
            
           sqlquery.addEntity(Student.class);
           
           List<Student>list=sqlquery.list();
           
           for(Student s:list)
           {
        	   System.out.println("Roll Number "+s.getRno());
        	   System.out.println("Name        "+s.getName());
        	   System.out.println("Per         "+s.getPer());
        	   System.out.println("City        "+s.getCity());

        	   System.out.println("------------------------------------");
           }
          
    
            
            // // Entity SQL Query with Positional Parameter
            
            SQLQuery sqlquery=session.createSQLQuery("select * from student where sper>=?0 ");
            sqlquery.setParameter(0, 70);
            
            sqlquery.addEntity(Student.class);
            
            List<Student>list=sqlquery.list();
            
            for(Student s:list)
            {
         	   System.out.println("Roll Number "+s.getRno());
         	   System.out.println("Name        "+s.getName());
         	   System.out.println("Per         "+s.getPer());
         	   System.out.println("City        "+s.getCity());

         	   System.out.println("------------------------------------");
            }
 
            
         // Entity SQL Query with Named Parameter
            
            SQLQuery sqlquery=session.createSQLQuery("select * from student where sper>=:abc ");
            sqlquery.setParameter("abc", 70);
            
            sqlquery.addEntity(Student.class);
            
            List<Student>list=sqlquery.list();
            
            for(Student s:list)
            {
         	   System.out.println("Roll Number "+s.getRno());
         	   System.out.println("Name        "+s.getName());
         	   System.out.println("Per         "+s.getPer());
         	   System.out.println("City        "+s.getCity());

         	   System.out.println("------------------------------------");
            }
         
            
       // Scalar SQL Query With Named Parameter
            
            SQLQuery sqlquery=session.createSQLQuery("select sname,sper from student  ");

            List<Object[]> list=sqlquery.list();
            
            for(Object[] ob:list)
            {
            	for(Object data:ob)
            	{
            		System.out.print(data+" ");
            	}
            	System.out.println();
            }
           
          //INSERT 
            
            SQLQuery sqlquery=session.createSQLQuery("insert into student values(?0,?1,?2,?3)");
            sqlquery.addEntity(Student.class);
            sqlquery.setParameter(0, 111);
            sqlquery.setParameter(1, "YYY");
            sqlquery.setParameter(2, 99);
            sqlquery.setParameter(3, "Jalgaon");
            
            int cnt=sqlquery.executeUpdate();
            
            System.out.println("No Of Rows Affedcted"+cnt);


            
            //Update
            
            SQLQuery sqlquery=session.createSQLQuery("update student set scity=?0 where srno=?1");
            sqlquery.addEntity(Student.class);
            sqlquery.setParameter(0, "Muktainager");
            sqlquery.setParameter(1, 111);

            
            int cnt=sqlquery.executeUpdate();
            
            System.out.println("No Of Rows Affedcted"+cnt);
            

            //DELETE
            
            SQLQuery sqlquery=session.createSQLQuery("delete from student where scity='Muktainager'");
            sqlquery.addEntity(Student.class);
//            sqlquery.setParameter(0, "Muktainager");
//            sqlquery.setParameter(1, 111);

            
            int cnt=sqlquery.executeUpdate();
            
            System.out.println("No Of Rows Affedcted"+cnt);
            
         
            
            //Drop
            
            SQLQuery sqlquery=session.createSQLQuery("drop table student");
            sqlquery.addEntity(Student.class);
//            sqlquery.setParameter(0, "Muktainager");
//            sqlquery.setParameter(1, 111);

          
            int cnt=sqlquery.executeUpdate();
            
  */           
            
            
            
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