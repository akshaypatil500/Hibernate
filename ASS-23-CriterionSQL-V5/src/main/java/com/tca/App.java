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

        //----------------Criterion API'S--------------------------
            
            //select * from student;
            
/*
            Criteria criterian =session.createCriteria(Student.class);
            
            List<Student> list =criterian.list();
            for(Student s:list)
            {
         	   System.out.println("Roll Number "+s.getRno());
         	   System.out.println("Name        "+s.getName());
         	   System.out.println("Per         "+s.getPer());
         	   System.out.println("City        "+s.getCity());

         	   System.out.println("------------------------------------");
            }
           
          
            //select * from student order by per desc;
            
            Criteria criterian =session.createCriteria(Student.class);
            Order order=Order.desc("per");
            criterian.addOrder(order);

            List<Student> list =criterian.list();
            for(Student s:list)
            {
         	   System.out.println("Roll Number "+s.getRno());
         	   System.out.println("Name        "+s.getName());
         	   System.out.println("Per         "+s.getPer());
         	   System.out.println("City        "+s.getCity());

         	   System.out.println("------------------------------------");
            }
            

           // select * from student where per>=70 and per<=90 order by desc;
            
            
            Criteria criteria =session.createCriteria(Student.class);
            
            Criterion c1=Restrictions.ge("per",70.0); 
            Criterion c2=Restrictions.le("per",80.0); 
            
            Order order=Order.desc("per");
            
            criteria.add(c1);
            criteria.add(c2);
            
            criteria.addOrder(order);

            List<Student> list =criteria.list();
            for(Student s:list)
            {
         	   System.out.println("Roll Number "+s.getRno());
         	   System.out.println("Name        "+s.getName());
         	   System.out.println("Per         "+s.getPer());
         	   System.out.println("City        "+s.getCity());

         	   System.out.println("------------------------------------");
            }
          
             
            //Scaler Query
            // select name,per from student where per>=70 and per<=90 order by desc;
            
            
            Criteria criteria =session.createCriteria(Student.class);
            
            Criterion c1=Restrictions.ge("per",70.0); 
            Criterion c2=Restrictions.le("per",80.0); 
            
            Order order=Order.desc("per");
                    
            ProjectionList pl=Projections.projectionList();
            pl.add(Projections.property("name"));
            pl.add(Projections.property("per"));
            
            criteria.setProjection(pl);
            criteria.add(c1);
            criteria.add(c2);
            criteria.addOrder(order);

			List<Object[]> list = criteria.list();

			for (Object[] ob : list) {
				for (Object data : ob) {
					System.out.print(data + " ");
				}
				System.out.println();
			}
 
            
            //select count(*) from student;
            
            Criteria criteria=session.createCriteria(Student.class);
            criteria.setProjection(Projections.rowCount());
            Long cnt=(Long)criteria.uniqueResult();
            
            System.out.println("No of Records :"+cnt);


            //select max(*) from student;
            
            Criteria criteria=session.createCriteria(Student.class);
            criteria.setProjection(Projections.max("per"));
            Double maxtpr=(Double)criteria.uniqueResult();
            
              
            System.out.println("Topper Student "+list.get(0));
 
            
            //LIKE 
            //select * from student where city like 'A%';
             * 
            Criteria criteria=session.createCriteria(Student.class);
            
            criteria.add(Restrictions.like("city", "p%"));
            
            List<Student> list=criteria.list();
            
            for(Student s:list)
            {	 
               System.out.println(s.getRno()+" "+s.getName()+" "+s.getPer()+" "+s.getCity());
            }

            
            //Group by
            
            //select city,count(*) from student group by city;
            
            Criteria criteria=session.createCriteria(Student.class);
           
            ProjectionList pl=Projections.projectionList();
            pl.add(Projections.groupProperty("city"));
            pl.add(Projections.rowCount());
            
            criteria.setProjection(pl);

        	List<Object[]> list = criteria.list();

			for (Object[] ob : list) {
				for (Object data : ob) {
					System.out.print(data + " ");
				}
				System.out.println();
			}
			
		
            //select city,count(*) from student group by city having count(*)>1;
			
            Criteria criteria=session.createCriteria(Student.class);
           
            ProjectionList pl=Projections.projectionList();
            pl.add(Projections.groupProperty("city"));
            pl.add(Projections.rowCount());
            
            criteria.setProjection(pl);
                                                            // 0   1      0      1
        	List<Object[]> list = criteria.list(); //L--->[['pune',2], ['mumbai',2]]

			for (Object[] arrob : list) {
					
					Long cnt=(Long) arrob[1];
					if(cnt>1)
					{
					System.out.println("City :" +arrob[0]+" "+ " No Of Student "+cnt);
					}
				
				System.out.println();
			}
            
            
           //UPDATE 
            
            Criteria criteria=session.createCriteria(Student.class);
            criteria.add(Restrictions.eq("rno",108));

            List<Student> list =criteria.list();
            for(Student s:list)
            {
         	  s.setPer(99.0);;
            }
        
            
            //DELETE
            
            Criteria criteria=session.createCriteria(Student.class);
            criteria.add(Restrictions.eq("rno",108));

            List<Student> list =criteria.list();
            for(Student s:list)
            {
         	 session.delete(s);
            }
*/	             
            Criteria criteria=session.createCriteria(Student.class);
            criteria.add(Restrictions.eq("city","Mumbai"));

            List<Student> list =criteria.list();
            for(Student s:list)
            {
         	 session.delete(s);
            }
            System.out.println("No Of Records Deleted "+ list.size());
            
            
            
            
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