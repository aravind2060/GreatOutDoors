package com.capgemini.greatoutdoors.exceptions;

@SuppressWarnings("serial")
public class ProductException extends Exception {
	
	String log;
	
	public ProductException(String log) {
		this.log=log;
	}
	
	

	public void printLog()
	{
		System.err.println(log);
	}

}
