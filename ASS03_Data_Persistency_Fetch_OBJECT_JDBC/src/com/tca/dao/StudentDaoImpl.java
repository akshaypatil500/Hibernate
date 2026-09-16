package com.tca.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tca.entities.Student;

public class StudentDaoImpl implements StudentDao {

	public String save(Student ob) {

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

			// Prepare SQL Query
			ps = con.prepareStatement("insert into student values(?,?,?)");

			ps.setInt(1, ob.getRno());
			ps.setString(2, ob.getName());
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
		} finally {
			try {
				con.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	@Override
	public List<Student> getALLStudents() {

		
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Student> L=new ArrayList<>();
		
		final String DB_URL = "jdbc:mysql://localhost:3306/hfb02";
		final String DB_USER = "root";
		final String DB_PWD = "akki";

		try {

			// Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish Connection
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);

			ps = con.prepareStatement("select * from student");
			
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				int rno=rs.getInt("rno");
				String name=rs.getString("name");
				double per=rs.getDouble("per");
				
				Student student = new Student();
				student .setRno(rno);
				student .setName(name);
				student .setPer(per);
                L.add(student );				
			}
			if(L.isEmpty())
			{
				return null;
			}
			else
			{
				return L;
			}

		} catch (Exception e) {
			return null;
		}

		finally {
			try {
				rs.close();
				con.close();
			} catch (Exception e) {

				return null;
			}
		}
		
		
	}

}
