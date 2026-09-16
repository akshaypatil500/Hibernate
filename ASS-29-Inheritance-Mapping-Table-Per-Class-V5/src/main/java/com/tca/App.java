package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entites.Employee;
import com.tca.entites.Executive;

public class App {
    public static void main(String[] args) {

        Configuration configuration = null;
        SessionFactory sf = null;
        Session session = null;
        Transaction txn = null;

        try {
            configuration = new Configuration();
            configuration.configure();

           // configuration.addAnnotatedClass(Student.class);

            sf = configuration.buildSessionFactory();
            session = sf.openSession();
            txn = session.beginTransaction();

        //----------------Inheritance Mapping Table-Per-Class--------------------------
            //Inserting Data
/*           
            Employee emp=new Employee();
            emp.setEid(111);
            emp.setEname("PPP");
            session.save(emp);
            
            Executive exe=new Executive();          
            exe.setEid(222);
            exe.setEname("QQQ");
            exe.setErole("operation");
            
            session.save(exe);
  
*/
            //Fetching Data
 /*         //Works
            Employee emp=session.get(Employee.class, 111);
            System.out.println("Employee Information");
            System.out.println("Employee Id "+emp.getEid());
            System.out.println("Employee Name "+emp.getEname());
  */    
            /*//Works
            Employee emp=session.get(Employee.class, 222);
            System.out.println("Employee Information");
            System.out.println("Employee Id "+emp.getEid());
            System.out.println("Employee Name "+emp.getEname());
  */       

            
            /*Employee emp=session.get(Executive.class, 222);
            System.out.println("Employee Information");
            System.out.println("Employee Id "  +  emp.getEid());
            System.out.println("Employee Name "+  emp.getEname());
            System.out.println("Employee Name "+   emp.getRole());  // not Allowed

 */
            //Not Works
            // class type Ani discriminator value match zali Pahije 
            
 /*         Employee emp=session.get(Executive.class, 111);
            System.out.println("Employee Information");
            System.out.println("Employee Id "  +  emp.getEid());
            System.out.println("Employee Name "+emp.getEname());
 */
            
            Executive exe=session.get(Executive.class, 222);
            System.out.println("Employee Information");
            System.out.println("Employee Id "  +  exe.getEid());
            System.out.println("Employee Name "+  exe.getEname());
            System.out.println("EXEcutive Role "+exe.getErole());
            
            
      




           
       
            
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