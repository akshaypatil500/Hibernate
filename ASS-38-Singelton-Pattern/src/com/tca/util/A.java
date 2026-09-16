package com.tca.util;

public class A {
	
	private static A aob;//null
	
	private A() {};
	
	public static A getInstance()
	{
		if(aob==null)
		{
			aob=new A();
		}
		return aob;
	}
	
	public void display()
	{
		System.out.println("I am in display");
	}

}
