package com.tca;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tca.entites.Course;
import com.tca.entites.Student;
import com.tca.entites.StudentCourse;






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
            

         //i wnat to asssign course-111 to Student -101
/*         
         Student s=new Student();
         s.setRno(101);
         s.setName("AAA");
         
         Course c=new Course();
         c.setCid(111);
         c.setCname("Core Java");
         
         StudentCourse sc=new StudentCourse();
         sc.setId(1);
         sc.setStudent(s);
         sc.setCourse(c);
         sc.setReg_date(LocalDate.now());
         
         session.save(sc); // sc kelya varti Student ,Course ka save zale because aapn StudentCourse madhe cascadeType.All kele aahe
 */        
         //List<StudentCourse> ls=Arrays.asList(sc);
         
         //i wnat to asssign course-222 to Student -101
/*         
         Student s=session.get(Student.class, 101);
         Course c=new Course();
         c.setCid(222);
         c.setCname("Advance Java");
         
         StudentCourse sc=new StudentCourse();
         sc.setId(2);
         sc.setCourse(c);
       //sc.setStudent(s);
         sc.setReg_date(LocalDate.of(2025, 3, 15));
         session.save(sc);
*/         
/*         
        // Above Scenario 
         Student s=session.get(Student.class, 101);
         StudentCourse sc=session.get(StudentCourse.class,2);
         sc.setStudent(s);
         
         session.update(sc);
*/
         
        // Student-102 has taken admission but dont have any course yet.
        // Adding Only Student
/*            
          Student s=new Student();
          s.setRno(102);
          s.setName("BBB");
          session.save(s);
*/
          
            //Lanuching Course-333 hibernate but dont have admission yet
            //Ading only Course
/*            
            Course c=new Course();
            c.setCid(333);
            c.setCname("Hibernate");
            session.save(c);
*/
            //Student-102 has Taken admission fro Course-111 Core Java
/*

            Student s=session.get(Student.class, 102);
            Course c=session.get(Course.class, 111);
            
            StudentCourse sc=new StudentCourse();
            sc.setId(3);
            sc.setStudent(s);
            sc.setCourse(c);
            sc.setReg_date(LocalDate.now());
            
            session.save(sc);
 */          
 /*           
            //Student_Course madhle CascadeMule Delete honar nahi kadhave lagel 
            StudentCourse sc=session.get(StudentCourse.class, 3);
            session.delete(sc);
*/           
            
/*            
            //Student-103 has taken admission fro course-333 Hibernate
            
            Student s=new Student();
            s.setRno(103);
            s.setName("CCC");
            
            Course c=session.get(Course.class, 333);
            
            StudentCourse sc=new StudentCourse();
            sc.setId(4);
            sc.setStudent(s);
            sc.setCourse(c);
            sc.setReg_date(LocalDate.now());
            
            session.save(sc);
*/            
            
 /******************************Fetching LOgic ********************/
            
            //i want to see Courses joined by student-101
/*            
            Student s=session.get(Student.class, 101);
            
            System.out.println("Student Rno"+s.getRno());
            System.out.println("Student Name"+s.getName());

            
            
            List<StudentCourse> scRegidtration=s.getRegs();
            
            for(StudentCourse sc:scRegidtration)
            {
                System.out.println("Reg ID"+sc.getId());
                System.out.println("Reg Date"+sc.getReg_date());

                Course c=sc.getCourse();
                
                System.out.println("Course Id"+c.getCid());
                System.out.println("Course Name"+c.getCname());
                
                System.out.println();

            }
*/
            
           // i want to list of Student who has taken admisson fro course=111
/*            
            Course c=session.get(Course.class, 111);
            		
            System.out.println("Course Id "+c.getCid());
            System.out.println("Course Name "+c.getCname()); 
            
            List<StudentCourse> scRegidtration=c.getRegs();

            
            for(StudentCourse sc:scRegidtration)
            {
                System.out.println("Reg ID "+sc.getId());
                System.out.println("Reg Date "+sc.getReg_date());

                Student s=sc.getStudent();
                
                System.out.println("Student Rno "+s.getRno());
                System.out.println("Student Name "+s.getName());

                System.out.println();

            }
            		
*/
 /*           
           // Find Student-Course Information Whose registration take place on 21 may
            
            //Using HQL Fetching all Records
            Query query=session.createQuery("From StudentCourse where reg_date='2026-05-21'");
            
            List<StudentCourse>sclist=query.list();
            
            for(StudentCourse sc:sclist)
            {
                System.out.println("Reg ID "+sc.getId());
                System.out.println("Reg Date "+sc.getReg_date());

                Student s=sc.getStudent();
                
                System.out.println("Student Rno "+s.getRno());
                System.out.println("Student Name "+s.getName());

                System.out.println();
                
                Course c=sc.getCourse();
                
                System.out.println("Course Id"+c.getCid());
                System.out.println("Course Name"+c.getCname());
                
                System.out.println();

            }
 */           
            // Find Student-Course Information Whose registration take place on 21 may

         
            
            Query query = session.createQuery(

            	    "select s.name, c.cname, sc.reg_date " +

            	    "from Student s, Course c, StudentCourse sc " +

            	    "where s.rno = sc.student.rno " +

            	    "and c.cid = sc.course.cid " +

            	    "and sc.reg_date = '2026-05-21'"
            	);
            
            List<Object[]> list=query.list();
            
//            for(Object[] obj : list)
//            {
//                System.out.println(obj[0]); // student name
//                System.out.println(obj[1]); // course name
//                System.out.println(obj[2]); // reg_date
//            }
            
            for(Object[] ob:list)
            {
            	for(Object data:ob)
            	{
                    System.out.println(data);

            	}
            	 System.out.println(); // blank line after each record
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