package com.tca;

import com.tca.factory.CarFactory;
import com.tca.pojo.Car;
import com.tca.pojo.Mahindra;
import com.tca.pojo.Tata;

public class App {

	public static void main(String[] args) {
		
		
		
		Car c=CarFactory.getCar();
		System.out.println(c);
		c.Driving();
		c.Stop();
		
		
		

/*
		//loose Coupling
      Car c1= new Tata();
      c1.Driving();
      c1.Stop();
      
      System.out.println("----------------------------------------------------");
      
      Car c2=new Mahindra();
      c2.Driving();
      c2.Stop();
      
      //Tight Coupling
      Tata t=new Tata();
      t.Driving();
      t.Stop();
      
      Mahindra m=new Mahindra();
      m.Driving();
      m.Stop();
      
*/
	}

}
