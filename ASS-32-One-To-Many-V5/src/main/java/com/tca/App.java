package com.tca;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entites.Department;
import com.tca.entites.Employee;



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

        //----------------One-TO-MAny-Association Mapping--------------------------
            
/*
           // When we are Saving Department data  Employee data is being saved Automatically
           // Because of @OneToMany(mappedBy ="dept" ,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	       // List<Employee> emps;

            Department d=new Department();
            d.setDid(111);
            d.setDname("cs");
            
            Employee e1=new Employee();
            e1.setEid(101);
            e1.setEname("AAA");
            e1.setSalary(80000.0);
            e1.setDept(d);
            
            Employee e2=new Employee();
            e2.setEid(103);
            e2.setEname("CCC");
            e2.setSalary(120000.0);
            e2.setDept(d);
           
            
            List<Employee> emps=new ArrayList<>();
            emps.add(e1);
            emps.add(e2);
            
            d.setEmps(emps);  
            
            session.save(d);
*/
/*
            // When we are Saving Employee data Department data is being saved Automatically
            // Because of :- @ManyToOne(cascade = CascadeType.ALL)
        	// @JoinColumn(name="dept_id")
        	// Department dept;

            Department d=new Department();
            d.setDid(222);
            d.setDname("Arts");
            
            Employee e=new Employee();
            e.setEid(102);
            e.setEname("BBB");
            e.setSalary(10000.0);
            e.setDept(d);
            
            session.save(e);
 */  
            
 /*           
            // When we will delete the Dept the Employee of that dept will get Deleted
            
            Department d=(Department) session.get(Department.class, 222);
            session.delete(d);
 */      
            
 /*          //Can i insert dept as 'NULL' for Employee.
            //YES
            //NO if nullable=false property is applied on dept_id 
            // 
            
            Employee e=new Employee();
            e.setEid(104);
            e.setEname("DDD");
            e.setSalary(45000.0);
            
            session.save(e);
*/            
            
            // Above Scenario continud-
            //Company Decided After  5 Days  emp-104 gets dept=222
/*
            Department d=(Department) session.get(Department.class, 222);
            
            Employee e=(Employee) session.get(Employee.class, 104);
            e.setDept(d);
            session.update(e);
*/
            
            //Fetching Logic
            // DepartmentWise - did(111) print employee information
/*            
            Department d=session.get(Department.class, 111);
            System.out.println("Departement Information");
            System.out.println("Department ID"+ d.getDid());
            System.out.println("Departement Name"+ d.getDname());
            
            List<Employee> elist=d.getEmps();
            for(Employee e :elist)
            {
            	System.out.println("Employee Information");
            	System.out.println("Employee ID"+e.getEid());
            	System.out.println("Employee Name "+e.getEname());
            	System.out.println("Employee Salary"+e.getSalary());
            	System.out.println(e);//---- toString() calling
            	System.out.println("---------------------------------");

            }
 */           
            //Here i want to print Employee="102"s eid ,ename,salary and department details
            
			Employee e = session.get(Employee.class, 104);
			Department d = e.getDept();

			System.out.println("Employee Information");
			System.out.println("Employee ID" + e.getEid());
			System.out.println("Employee Name " + e.getEname());
			System.out.println("Employee Salary" + e.getSalary());
			System.out.println("Department ID" + d.getDid());
			System.out.println("Departement Name" + d.getDname());
			System.out.println("---------------------------------");

			
            
            
            
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