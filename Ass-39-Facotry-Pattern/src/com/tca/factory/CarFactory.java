	package com.tca.factory;
	
	import com.tca.pojo.Car;
	import com.tca.pojo.Tata;
	
	public class CarFactory {
		
		  private static Car c; 
		  private CarFactory() {};
		  
		  
		  public static Car getCar()
		  {
			  if(c==null)
			  {
				  c=new Tata();  //new Mahindra
			  }
			  return c;
		  }
	
	}
