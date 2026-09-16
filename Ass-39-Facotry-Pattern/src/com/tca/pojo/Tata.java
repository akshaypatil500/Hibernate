package com.tca.pojo;

public class Tata implements Car {

	@Override
	public void Driving() {

		System.out.println("I am Running on MRF tyre");

	}

	@Override
	public void Stop() {

		System.out.println("I am Stoppig using Air Break");
	}

}
