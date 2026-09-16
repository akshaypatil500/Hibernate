package com.tca.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.tca.entities.Student;

public class StudentDaoImpl implements StudentDao {

	
	public String save(Student ob) {
		
		Connection con=null;
		PreparedStatement ps=null;
		
		  final String DB_URL = "jdbc:mysql://localhost:3306/hfb02";
	      final String DB_USER = "root";
	      final String DB_PWD = "akki";
		
         try {
        	 
        	  // Load Driver
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            // Establish Connection
	            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
	            
	            
	            // Prepare SQL Query
	            ps = con.prepareStatement("insert into student values(?,?,?)");
	            
	            ps.setInt(1, ob.getRno());
	            ps.setString(2,ob.getName());
	            ps.setDouble(3, ob.getPer());
	            
                int sval = ps.executeUpdate();
	            
	            if (sval == 1) {
	            	 return "SUCCESS";
	            	 } else {
	            		 return "FAILED";
	            }
	            	 
		} catch (Exception e) {
			e.printStackTrace();
			return "FAILED";
		}
         finally
         {
        	 try {
        		 con.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
         }
		
	}

}
