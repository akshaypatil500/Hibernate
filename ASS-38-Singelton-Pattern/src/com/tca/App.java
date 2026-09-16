package com.tca;

import com.tca.util.A;

public class App {

	public static void main(String[] args) {


		A ob1=A.getInstance();
		
		A ob2=A.getInstance();

		
		System.out.println(ob1);
		System.out.println(ob2);
		
		//Here you are creating only one object of class 'A'
		// You can create multiple reference variable of class 'A'
		
		ob1.display();
		ob2.display();


	}

}
