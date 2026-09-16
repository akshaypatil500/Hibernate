package com.tca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
            

        // Adding Student-101 with 2 Courses 111,222
/*            
           Student s=new Student();
           s.setRno(101);
           s.setName("AAA");
           
           Course c1=new Course();
           c1.setCid(111);
           c1.setCname("Core Java");
           
           Course c2=new Course();
           c2.setCid(222);
           c2.setCname("Advanced Java");
           
           s.setCourses(Arrays.asList(c1,c2));
           session.save(s);
*/ 
/*           
            //Option-1 to create list
			List<Course> clist = new ArrayList<>();
			clist.add(c1);
			clist.add(c2);

			// Option-2 to Create list
			List<Course> clist = Arrays.asList(c1, c2);
			s.setCourses(clist);

			// Using Parameterized Constructor
			s.setCourses(Arrays.asList(new Course(111, "Core Java"), new Course(222, "Advanced Java")));
          
            
            
            // A New Student-102 want to take admission for course core Java cid=111
            
            Student s=new Student();
            s.setRno(102);
            s.setName("BBB");
            s.setCourses(Arrays.asList(session.get(Course.class,111)));
            session.save(s);
            
            
            // brut-Force Way to create list
            //Course c=session.get(Course.class, 111);
            // List<Course> clist=new ArrayList<>();
            // clist.add(c);
            
            // Smarter way to save
            //session.save(Arrays.asList(session.get(Course.class,111)));
            
            //session.save(new Student(101,"BBB",Arrays.asList(session.get(Course.class,111))));
*/
/*            
            // i want to save only course
            Course c1=new Course();
            c1.setCid(333);
            c1.setCname("Hibernate");
            session.save(c1);
*/             
            
            //Here I want to assign existing course 333 to new Student 103;
/*            
            Course c=session.get(Course.class, 333);
            Student s=new Student();
            s.setRno(103);
            s.setName("CCC");
           // List<Course> clist =new ArrayList<>();
           //clist.add(c);
            s.setCourses(Arrays.asList(c));
            session.save(s);
*/
/*            
            //I want to see courses joined by Student-101
            
            Student s=session.get(Student.class, 101);
            List<Course> crs=s.getCourses();
            System.out.println("**************Student Information**********");
            System.out.println("Roll NUmber"+s.getRno());
            System.out.println("Name"+s.getName());

            System.out.println("**************Courses Information**********");

            for(Course c:crs)
            {
                System.out.println("Course ID"+c.getCid());
                System.out.println("Course Name"+c.getCname());
                System.out.println();
              }  
*/
            
            //I want to list of Student who has taken admission for course-111
            
            Course c=session.get(Course.class, 111);
            List<Student> std=c.getStudents();
            
            System.out.println("**************Courses Information**********");
            System.out.println("Course ID"+c.getCid());
            System.out.println("Course Name"+c.getCname());
            System.out.println();

           System.out.println("**************Student Information**********");
           
            for(Student s: std) {

                 System.out.println("Roll NUmber"+s.getRno());
                 System.out.println("Name"+s.getName());
                 System.out.println();

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