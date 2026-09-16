package com.tca;

import java.util.List;
import java.util.Scanner;

import com.tca.entites.Student;
import com.tca.factory.StudentServiceFactory;
import com.tca.service.StudentService;
import com.tca.util.HibernateUtil;

public class App {
    public static void main(String[] args) {
    	
    	
		while (true) {
			Scanner sc = new Scanner(System.in);

			System.out.println("...Menu...");
			System.out.println(" 1.Save ");
			System.out.println(" 2.Fetch By Id ");
			System.out.println(" 3.Fetch By Name");
			System.out.println(" 4.Fetch By City ");
			System.out.println(" 5.Update ");
			System.out.println(" 6.Delete ");
			System.out.println(" 7.Exit ");

			System.out.print("What is Your Choice");
			int n = sc.nextInt();

			switch (n) {
			case 1:
				optionSave();
				break;
			case 2:
				fetchStudentById();
				break;
			case 3:
				fetchStudentByName();
				break;
			case 4:
				fetchStudentByCity();
				break;
			case 5:
				modifyStudent();
				break;
			case 6:
				deleteStudent();
				break;
			case 7:		
				System.out.println("**********************Shutdown System!!*******************");
				HibernateUtil.closeSessionFactory();
				System.exit(0);
       	    
       	    
       	    }
 	}
    	
    	
    
}   
    
    public static void deleteStudent()
    {
    	 Scanner sc=new Scanner(System.in);
       	
         System.out.println("Enter The Student ID You Want to Delete : ");
       	 int id=sc.nextInt();
       	
       	 StudentService service =StudentServiceFactory.getStudentservice();
       	
       	boolean status=service.removeStudent(id);
       	
       	if(status)
       	{
       		System.out.println("Record is Deleted Succcessfully fro Roll Number :"+id);
       	}
       	else
       	{
       		System.out.println("Record is not found for roll number "+id);
       	}
    }
    

    
    public static void modifyStudent()
    {
    	 Scanner sc=new Scanner(System.in);
       	
         System.out.println("Enter The Student ID : ");
       	 int id=sc.nextInt();
       	
       	StudentService service =StudentServiceFactory.getStudentservice();
       	
       	boolean status=service.modifyStudent(id);
       	
       	if(status)
       	{
       		System.out.println("Record is Updated Succcessfully fro Roll Number :"+id);
       	}
       	else
       	{
       		System.out.println("Record is not found for roll number "+id);
       	}
    }
    
    
    public static void fetchStudentByCity()
    {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter The Student City to Search : ");
		String city = sc.nextLine();

		StudentService service = StudentServiceFactory.getStudentservice();

		List<Student> studentlist = service.fetchStudentByCity(city);
  	
  	if(studentlist==null || studentlist.isEmpty())
  	{
  		System.out.println("No Record Found For Roll Number :"+city);
  	}
  	else
  	{
  		System.out.println("************Record Found**************");
  		
  		
  		for(Student student: studentlist)
  		{
     	System.out.println("Student Roll Number : "+student.getRno());
     	System.out.println("Student Name        : "+student.getName());
     	System.out.println("Student Percentage  : "+student.getPer());
     	System.out.println("Student City        : "+student.getCity());
  		System.out.println("---------------------------------------");

  		}
  		System.out.println();

  	}
 	   
    }
    
       public static void fetchStudentByName()
       {
    	  Scanner sc=new Scanner(System.in);
         	
       	 System.out.println("Enter The Student Name to Search : ");
     	 String  name=sc.nextLine();
     	
     	StudentService service =StudentServiceFactory.getStudentservice();
     	
        List<Student> studentlist=service.fetchStudentByName(name);
     	
     	if(studentlist==null || studentlist.isEmpty())
     	{
     		System.out.println("No Record Found For Roll Number :"+name);
     	}
     	else
     	{
     		System.out.println("************Record Found**************");
     		
     		
     		for(Student student: studentlist)
     		{
        	System.out.println("Student Roll Number : "+student.getRno());
        	System.out.println("Student Name        : "+student.getName());
        	System.out.println("Student Percentage  : "+student.getPer());
        	System.out.println("Student City        : "+student.getCity());
     		System.out.println("---------------------------------------");

     		}
     		System.out.println();

     	}
    	   
       }
       
       
    
       public static void fetchStudentById()
       {
      	 Scanner sc=new Scanner(System.in);
      	
         System.out.println("Enter The Student ID : ");
       	 int id=sc.nextInt();
       	
       	StudentService service =StudentServiceFactory.getStudentservice();
       	
       	Student student=service.fetchStudentById(id);
       	
       	if(student==null)
       	{
       		System.out.println("No Record Found For Roll Number :"+id);
       	}
       	else
       	{
       		System.out.println("************Record Found**************");
       		
       		System.out.println("---------------------------------------");
       		
          	System.out.println("Student Roll Number : "+student.getRno());
          	System.out.println("Student Name        : "+student.getName());
          	System.out.println("Student Percentage  : "+student.getPer());
          	System.out.println("Student City        : "+student.getCity());

          	

       	}
       	
      	 
       } 
       
        public static void optionSave()
        {
        	Scanner sc=new Scanner(System.in);
        	
        	System.out.println("Enter Student Name : ");
        	String name=sc.nextLine();
        	
        	System.out.println("Enter Student Per  : ");
        	Double per=sc.nextDouble();
        	
        	System.out.println("Enter Student City : ");
        	String city=sc.next();

        	
        	Student s=new Student();
        	s.setName(name);
        	s.setPer(per);
        	s.setCity(city);
        	
        	StudentService service=StudentServiceFactory.getStudentservice();

        	
        	Integer id=service.addStudent(s);
        	
        	if(id==null)
        	{
        		System.out.println("Failed To Saved");
        	}
        	else
        	{
        		System.out.println("Record Saved Successfully for Roll NUmber "+id);

        	}
        }
        
      
    
}
