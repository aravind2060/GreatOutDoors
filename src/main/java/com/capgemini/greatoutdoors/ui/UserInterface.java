package com.capgemini.greatoutdoors.ui;


import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.capgemini.greatoutdoors.dto.ProductDTO;
import com.capgemini.greatoutdoors.exceptions.ProductException;
import com.capgemini.greatoutdoors.service.ProductServiceImpl;

public class UserInterface 
{

	static Scanner scan=new Scanner(System.in);
	static ProductServiceImpl object=new ProductServiceImpl();
	public static void main(String[] args) throws ProductException
	{
	
	   printFilteredProducts();
//		Map<String,ProductDTO> mp=object.filterByName(null);
//		for(Map.Entry<String, ProductDTO> me:mp.entrySet())
//			System.out.println(me.getValue());
	}
   
	public static Map<String,ProductDTO> filterProducts() throws ProductException
	{
	  List<Integer> ListOfTotal=new ArrayList<>();
	  ListOfTotal.add(1);
	  ListOfTotal.add(2);
	  ListOfTotal.add(3);
	 int ListOfCompleted[]= {0,0,0};
	  
	  boolean isFirstTime=true;
	  Map<String,ProductDTO> map=null;
	  System.out.println(ListOfTotal.size());
	  
	  for(int i=0;i<ListOfTotal.size();i++)
	  {
		  
	     for(int j=0;j<ListOfTotal.size();j++)
	     {
	    	 if(ListOfTotal.get(j)==1 && ListOfCompleted[j]!=1)
	    	   System.out.println(j+1+" ) Filter by Name");
	    	 else if(ListOfTotal.get(j)==2 && ListOfCompleted[j]!=2)
	    		 System.out.println(j+1+" ) Filter by Brand");
	    	 else if(ListOfTotal.get(j)==3 && ListOfCompleted[j]!=3)
	    		 System.out.println(j+1+" ) Filter by Price");
	     }
	     System.out.print("Enter Choice:");
	     int input=scan.nextInt();
	     switch(input)
	     {
	     case 1:
	    	 if(ListOfTotal.contains(new Integer(input)) && isFirstTime)
	    	 {
	    		 map=object.filterProducts(input, null);
	    		 isFirstTime=false;
	    	 }
	    	 else
	    	 {
	    		 object.filterProducts(input, map);
	    	 }
	    	 ListOfCompleted[i]=input;
	    	 ListOfTotal.remove(new Integer(input));
	    	 printAll(map);
	    	 break;
	     case 2:
	    	 if(ListOfTotal.contains(new Integer(input)) && isFirstTime)
	    	 {
	    		 map=object.filterProducts(input, null);
	    		 isFirstTime=false;
	    	 }
	    	 else
	    	 {
	    		 object.filterProducts(input, map);
	    	 }
	    	 ListOfCompleted[i]=input;
	    	 ListOfTotal.remove(new Integer(input));
	    	 printAll(map);
	    	 break;
	     case 3:
	    	 if(ListOfTotal.contains(new Integer(input)) && isFirstTime)
	    	 {
	    		 map=object.filterProducts(input, null);
	    		 isFirstTime=false;
	    	 }
	    	 else
	    	 {
	    		 object.filterProducts(input, map);
	    	 }
	    	 ListOfCompleted[i]=input;
	    	 ListOfTotal.remove(new Integer(input));
	    	 printAll(map);
	    	 break;
	    	default:
	    		System.out.println("Invalid Input");
	     }
	     
	  }
	  
	  return map;
	  
	  
	}

	
	public static void printFilteredProducts()
	{
		try
		{
			Map<String,ProductDTO> map=filterProducts();
			for(Map.Entry<String, ProductDTO>me:map.entrySet())
				System.out.println(me.getValue());
		}
		catch(ProductException e)
		{
			e.printLog();
		}
	}
	
	public static void printAll(Map<String,ProductDTO> list)
	{
			for(Map.Entry<String, ProductDTO> me:list.entrySet())
             	System.out.println(me.getValue());	
	}

	
	
	
}
