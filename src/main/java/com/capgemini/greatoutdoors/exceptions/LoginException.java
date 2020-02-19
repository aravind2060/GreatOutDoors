package com.capgemini.greatoutdoors.exceptions;

@SuppressWarnings("serial")
public class LoginException extends Exception{

	String log;
   public LoginException(String log)
   {
	   this.log=log;
   }
   
   public void printLog()
   {
	  System.err.println(log);
   }
}
