package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddStudent {

	public static void main(String[] args) {
		 Connection con = null;
	        PreparedStatement ps = null;
	        
	        final String DB_URL = "jdbc:mysql://localhost:3306/hfb02";
	        final String DB_USER = "root";
	        final String DB_PWD = "akki";
	        
	        try {
	            // Load Driver
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            // Establish Connection
	            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
	            
	            int rno = 103;
	            String name = "CCC";
	            double per = 90;
	            
	            // Prepare SQL Query
	            ps = con.prepareStatement("insert into student values(?,?,?)");
	            
	            ps.setInt(1, rno);
	            ps.setString(2, name);
	            ps.setDouble(3, per);
	            
	            // Execute Query
	            int sval = ps.executeUpdate();
	            
	            if (sval == 1) {
	                System.out.println("Record Saved");
	            } else {
	                System.out.println("Not Saved");
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	}

}
