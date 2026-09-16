package com.tca;

import java.util.List;

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

            // -------------------------HQL---------------------------------------

            // SELECT * FROM student is equivalent to " from Student" HQL)

            /*
            Query query=session.createQuery("from Student");
            
            List<Student> L=query.list();
            
            for(Student s:L) {
            System.out.println(s.getRno()+" "+s.getName()+" "+s.getPer()+" "+s.getCity());
            }
            */

            // ------------------------------------------------

            // For Partial Fields

/*
            Query query=session.createQuery("select name,city from Student");
            List<Object[]> L=query.list();
            
            for(Object[] ob:L) {
                for(Object data:ob) {
                    System.out.print(data.toString()+" ");
                }
                System.out.println();
            }
*/

            
            // ORDER BY

/*
            Query query=session.createQuery("from Student order by per desc ");
            
            List<Student>list=query.list();
            
            for(Student s:list) {
            System.out.println(s.getRno()+" "+s.getName()+" "+s.getPer()+" "+s.getCity());
            }
*/

            // Where Clause

            /*
            Query query = session.createQuery("from Student where per=90 ");
            
            List<Student> list = query.list();
            
            for (Student s : list) {
                System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer() + " " + s.getCity());
            }
*/

            
            // Aggregate Function
 /*
            Query query = session.createQuery(
            "select max(per),min(per),count(*),avg(per),sum(per) from Student");
            
            List<Object[]> l = query.list();
            
            for(Object[] ob:l) {
                for(Object data:ob) {
                    System.out.print(data.toString()+" ");
                }
                  System.out.println();
            }
 */
          

 /*
            Query query1 = session.createQuery("select count(*) from Student");
            
            List<Long> l1 = query1.list();
            
            System.out.println("No Of Student " + l1.get(0));
            
            Query query2 = session.createQuery("select max(per) from Student");
            
            List<Long> l2 = query2.list();
            
            System.out.println("Max Per Student " + l2.get(0));
*/

           
            // Group by
            
/*            Query query = session.createQuery("select city from Student group by city having count(*)>=2 ");
			  List<Object> l = query.list();

			
				for (Object data : l) {
					System.out.println(data.toString() + " ");
				}
*/				
	
			
			
/*			Query query = session.createQuery("select city,count(*) from Student group by city having count(*)>=2 ");
			List<Object[]> l = query.list();

			for (Object[] ob : l) {
				for (Object data : ob) {
					System.out.print(data.toString() + " ");
				}
				System.out.println();
	
			}
*/		
            
/*            Query query = session.createQuery("select per+2.5 from Student ");
			List<Double> l = query.list();

			
				for (Double data : l) {
					System.out.println(data);
				}
				
*/
            
           // AND 
            
/*			Query query = session.createQuery(" from Student where sper>=70 and sper<=80");

			List<Student> L = query.list();

			for (Student s : L) {
				System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer() + " " + s.getCity());
			}
*/			
            
            //OR
            
/*            Query query = session.createQuery(" from Student where city='pune' or city='mumbai'");

			List<Student> L = query.list();

			for (Student s : L) {
				System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer() + " " + s.getCity());
			}
*/
            
            //LIKE ,NOT LIKE,%,_(underScore)
            
/*            Query query = session.createQuery(" from Student where city like 'm%'");

			List<Student> L = query.list();

			for (Student s : L) {
				System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer() + " " + s.getCity());
			}
			
			
			 Query query = session.createQuery(" from Student where city not like 'p%'");

			List<Student> L = query.list();

			for (Student s : L) {
				System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer() + " " + s.getCity());
			}
*/
            
/*            //BETWEEN
            
            Query query = session.createQuery(" from Student where per between 70 and 80");

			List<Student> L = query.list();

			for (Student s : L) {
				System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer() + " " + s.getCity());
			}
*/			
            
            //NULL,NOT NULL
            
/*            Query query = session.createQuery("from Student where name is not null");

			List<Student> L = query.list();

			for (Student s : L) {
				System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer() + " " + s.getCity());
			}
			
			
			Query query = session.createQuery("from Student where name is null");

			List<Student> L = query.list();

			for (Student s : L) {
				System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer() + " " + s.getCity());
			}
*/	
            
            //SUBQUERY
            
/*            Query query = session.createQuery("from Student where per=(select max(per) from Student)");

			  List<Student> L = query.list();

			for (Student s : L) {
				System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer() + " " + s.getCity());
			}
 */           
            
            //Positional parameter
            
/*        	Query query = session.createQuery(" from Student where per>=?0 and per<=?1");
        	query.setParameter(0, 70);
        	query.setParameter(1, 80);

			List<Student> L = query.list();

			for (Student s : L) {
				System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer() + " " + s.getCity());
			}
*/
            
            //Named Parameter
            
/*          Query query = session.createQuery(" from Student where per>=:abc and per<=:tca");
        	query.setParameter("tca",80.0);
        	query.setParameter("abc", 70.0);

			List<Student> L = query.list();

			for (Student s : L) {
				System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer() + " " + s.getCity());
			}
*/
            
            
            
            
            //UPDATE
            
/*          Query query=session.createQuery("update Student set per=per+5 where city='pune'");
            int count=query.executeUpdate();
            
            System.out.println("No Of Records Updated "+count);
         
            
            //DELETE
            
            Query query=session.createQuery("delete from Student where city='pune'");
            int count=query.executeUpdate();
            
            System.out.println("No Of Records Deleted "+count);
 */           
            
            
            Query query =session.createQuery("select name ,city from Student");
            
            List<Object[]> list =query.list();
            
            for(Object[] ob:list)   
            {
               System.out.println("Student Name "+ob[0]);
               System.out.println("Student city "+ob[1]);

			}
               System.out.println();
           
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
            txn.rollback();
        } finally {

            session.close();
            sf.close();
        }
    }
}