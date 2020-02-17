package com.capgemini.greatoutdoors.util;



public class GenerateRandomString { 

	
	static String getAlphaNumericString() 
	{ 

	
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
									+ "0123456789"
									+ "abcdefghijklmnopqrstuvxyz"; 

		
		StringBuilder sb = new StringBuilder(6); 

		for (int i = 0; i < 6; i++) 
		{ 
			int index = (int)(AlphaNumericString.length()* Math.random()); 
			sb.append(AlphaNumericString.charAt(index)); 
		} 

		return sb.toString(); 
	} 

 
} 
