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

        //----------------Inheritance Mapping Table-Per-SubClass--------------------------
            //Inserting Data
 /*          
            Employee emp=new Employee();
            emp.setEid(111);
            emp.setEname("PPP");
            emp.setEsalary(5000.0);
            session.save(emp);
            
            Executive exe=new Executive();          
            exe.setEid(222);
            exe.setEname("QQQ");
            exe.setErole("operation");
            exe.setBonus(10000.0);
            session.save(exe);
  
*/
            //Fetching Data
            
            Employee emp=session.get(Employee.class, 111);
            System.out.println("Employee Information");
            System.out.println("Employee Id "+emp.getEid());
            System.out.println("Employee Name "+emp.getEname());
            System.out.println("Employee Salary "+emp.getEsalary());
            
            
            
            Executive exe=session.get(Executive.class, 222);
            System.out.println("Employee Information");
            System.out.println("Employee Id "  +  exe.getEid());
            System.out.println("Employee Name "+  exe.getEname());
            System.out.println("EXecutive Role "+ exe.getErole());
            System.out.println("EXEcutive Bonus "+ exe.getBonus());

            

            
           
           
 



           
       
            
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