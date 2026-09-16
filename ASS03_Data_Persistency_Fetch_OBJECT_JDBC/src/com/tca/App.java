package com.tca;

import java.util.List;

import com.tca.dao.StudentDao;
import com.tca.dao.StudentDaoImpl;
import com.tca.entities.Student;

public class App {

	public static void main(String[] args) {

		
		StudentDao studentdao = new StudentDaoImpl();
		List<Student> L = studentdao.getALLStudents();

		if (L == null) {
			System.out.println("No record Found");
		} else {
			for (Student s : L) {
				System.out.println("Roll Number" + s.getRno());
				System.out.println("Name " + s.getName());
				System.out.println("Percentage" + s.getPer());
				System.out.println("-------------------------");

			}
		}
	}
}
