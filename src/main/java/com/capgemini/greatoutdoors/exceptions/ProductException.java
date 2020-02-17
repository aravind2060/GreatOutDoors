package com.capgemini.greatoutdoors.exceptions;

public class ProductException extends Exception {
	
	String log;
	
	public ProductException(String log) {
		this.log=log;
	}
	
	

	void printLog()
	{
		System.out.println(log);
	}

}
