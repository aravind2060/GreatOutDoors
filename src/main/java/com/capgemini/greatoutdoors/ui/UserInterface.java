package com.capgemini.greatoutdoors.ui;


import java.io.Console;
import java.util.Map;
import java.util.Scanner;
import com.capgemini.greatoutdoors.dto.AddressDTO;
import com.capgemini.greatoutdoors.dto.ProductDTO;
import com.capgemini.greatoutdoors.dto.UserDTO;
import com.capgemini.greatoutdoors.exceptions.LoginException;
import com.capgemini.greatoutdoors.exceptions.ProductException;
import com.capgemini.greatoutdoors.service.ProductServiceImpl;
import com.capgemini.greatoutdoors.util.GenerateRandomString;

public class UserInterface 
{

	static Scanner scan=new Scanner(System.in);
	
	static ProductServiceImpl object=new ProductServiceImpl();
	
	public static void main(String[] args) 
	{

    	 isLoggedIn();
    }
    
   
	private static void ProductMasterController()
	{
		 System.out.println("\nWelcome Product Master You can able to Perform Following operations");
		while(true)
	    {
	      System.out.println("\n1)Add a Product \t 2)Update a Product \t 3)Delete a Product \n 4)Filter By ProductName \t 5)Filter By ProductBrand \t 6)Filter By ProductPrice \n 7) Search a Product \t 8) View a Product  \t 9) Log Out \tAnyother key to exit");
	      System.out.print("\nEnter Choice:");
	      int input=scan.nextInt();
	      scan.nextLine();
	      switch(input)
	      {
	      case 1:
	    	  addAProduct();
	    	  break;
	      case 2:
	    	  updateAProduct();
	    	  break;
	      case 3:
	    	  deleteAProduct();
	    	  break;
	      case 4:
	    	  filterByProductName();
	    	  break;
	      case 5:
	    	  filterByProductBrand();
	    	  break;
	      case 6:
	    	  filterByProductPrice();
	    	  break;
	      case 7:
	    	  searchAProduct();
	    	  break;
	      case 8:
	    	  viewAllProducts();
	    	  break;
	      case 9:
	    	  LogOutCurrentUser();
	    	  break;
	      default:
	    	  System.out.println("Thank You For Using Application !!");
	  		closeApplication();
	      }
	    }
	}
	private static void addProductMaster() 
	{
		UserDTO user=getUserDTO();
		object.createProductMaster(user);
		System.out.println("UserId:"+user.getUserId()+" \nPassword:"+user.getPassword());
		
	}

	private static void viewAllProducts() {
		try
		{
		 Map<String,ProductDTO> map=object.viewAllProducts();
		map.entrySet().stream().map(p->p.getValue()).forEach(System.out::println);
		}
		catch(ProductException e)
		{
			e.printLog();
		}
		
	}

	private static void searchAProduct() {
		System.out.print("\n Provide Input to search:");
		String input=scan.nextLine();
		try
		{
		 Map<String,ProductDTO>map=object.searchAProduct(input);
			map.entrySet().stream().map(p->p.getValue()).forEach(System.out::println);
		}catch(ProductException e)
		{
			e.printLog();
		}
		
	}

	private static void filterByProductPrice() {
		System.out.println("\n 1)Sort by Low to High \t 2)Sort by High to Low ");
		int input=scan.nextInt();
		scan.nextLine();
		switch(input)
		{
		case 1:
			try {
				Map<String,ProductDTO> map=object.filterByPrice();
				map.entrySet().stream().map(p->p.getValue()).forEach(System.out::println);
			} catch (ProductException e) {
				e.printLog();
			}
			break;
		case 2:
			try {
				Map<String,ProductDTO> map=object.filterByPrice();
				map.entrySet().stream().map(p->p.getValue()).sorted((a,b)->(a.getPrice()<b.getPrice())?1:-1).forEach(System.out::println);
			} catch (ProductException e) {
				e.printLog();
			}
			break;
			default:
				System.out.println("Invalid Input");
				return;
		}
		
		
	}

	private static void filterByProductBrand() {
		try {
			System.out.println("Available Product Brands:");
			object.viewAllProducts().entrySet().stream().map(p->p.getValue()).map(p->p.getProductBrand()).forEach(System.out::println);
			System.out.println("Enter Brand Name to Filter:");
			
			Map<String,ProductDTO> map=object.filterByBrand(scan.nextLine());
			map.entrySet().stream().map(p->p.getValue()).forEach(System.out::println);
		} catch (ProductException e) {
		
			e.printLog();
		}
		
	}

	private static void filterByProductName() 
	{
		
		try {
			System.out.println("Available Product:");
			object.viewAllProducts().entrySet().stream().map(p->p.getValue()).map(p->p.getProductName()).forEach(System.out::println);
			System.out.println("\nEnter Product Name to Filter:");
			Map<String,ProductDTO> map=object.filterByBrand(scan.nextLine());
			map.entrySet().stream().map(p->p.getValue()).forEach(System.out::println);
		} catch (ProductException e) {
		
			e.printLog();
		}
		
	}

	private static void deleteAProduct()
	{
	 try {
		object.viewAllProducts().values().stream().forEach(System.out::println);
		System.out.print("\nEnter productId to delete:");
		String input=scan.nextLine();
		boolean isdeleted=object.deleteProduct(input);
		if(isdeleted)
			System.out.println("Product Deleted SuccessFully !!");
		else
			System.out.println("Unable to delete product!");
	    }  
	 catch (ProductException e) 
	 {
		e.printLog();
	  }
	 
	
	}

	private static void updateAProduct() 
	{
		 viewAllProducts();
	     ProductDTO product=getInputOfProduct();
	    try 
	    {
			object.editProduct(product);
		} 
	    catch (ProductException e) {
			e.printLog();
		}
	  
	   
		
	}

	public static void addAProduct()
	{
	   	String productId=GenerateRandomString.getAlphaNumericString();
	   	System.out.print("\n Enter Price:");
	   	double price=scan.nextDouble();
	   	scan.nextLine();
	   	System.out.print("\nEnter Color:");
	   	String color=scan.nextLine();
	   	System.out.print("\nEnter Dimension:");
	   	String dimension=scan.nextLine();
	   	System.out.print("\nEnter Specification:");
	   	String specification=scan.nextLine();
	   	System.out.print("\nEnter manufacturer:");
	   	String manufacturer=scan.nextLine();
	   	System.out.print("\nEnter ProductName:");
	   	String productName=scan.nextLine();
	   	System.out.print("\nEnter ProductBrand:");
	   	String productBrand=scan.nextLine();
	   	System.out.print("\nEnter ProductQuantity:");
	   	int quantity=scan.nextInt();
	   	System.out.print("\nEnter ProductCategory:");
	   	int category=scan.nextInt();
	   	scan.nextLine();
	  try 
	  {
		boolean isinserted=object.addProduct(new ProductDTO(productId,price,color,dimension,specification,manufacturer,quantity,category,productName,productBrand));
	    if(isinserted)
	    	System.out.println("Product Entered in Db Successfully !!");
	    else
	    	System.out.println("Unable to Insert into Db ");
	  } 
	  catch (ProductException e) {
		e.printLog();
	 }
	  
	}
	
	public static ProductDTO getInputOfProduct()
	{
		String productId=GenerateRandomString.getAlphaNumericString();
	   	System.out.print("\n Enter Price:");
	   	double price=scan.nextDouble();
	   	System.out.print("\nEnter Color:");
	   	String color=scan.nextLine();
	   	System.out.print("\nEnter Dimension:");
	   	String dimension=scan.nextLine();
	   	System.out.print("\nEnter Specification:");
	   	String specification=scan.nextLine();
	   	System.out.print("\nEnter manufacturer:");
	   	String manufacturer=scan.nextLine();
	   	System.out.print("\nEnter ProductName:");
	   	String productName=scan.nextLine();
	   	System.out.print("\nEnter ProductBrand:");
	   	String productBrand=scan.nextLine();
	   	System.out.print("\nEnter ProductQuantity:");
	   	int quantity=scan.nextInt();
	   	System.out.print("\nEnter ProductCategory:");
	   	int category=scan.nextInt();
	   	scan.nextLine();
	  return new ProductDTO(productId,price,color,dimension,specification,manufacturer,quantity,category,productName,productBrand);	
	}
	
	private static void isLoggedIn()
	{
	   if(object.checkUserLoggedIn())
	   {
		   if(object.checkWhoLoggedIn())
		   {
			   AdminController();
		   }
		   else
		   {
			 ProductMasterController();  
		   }
	   }
	   else
	   {
		   System.out.println("Please Log In!!");
		   promptLogIn();
	   }
	}
	
	private static void AdminController() 
	{
	 System.out.println("\nWelcome Admin You can able to Perform Following operations");	
	  while(true)
	  {
	   System.out.println("\n\n1)Add a Product Master \t 2)View All Products \t 3)Search A Product \n 4)Filter a Product By Name \t 5)Filter Product By Price \n 6)Filter Product By Brand \t 7)LogOut \t Anyother key to exit");	  
	   System.out.print("\nEnter Choice:");
	   int input=scan.nextInt();
	   scan.nextLine();
	   switch(input)
	   {
	   case 1:
		    addProductMaster();
		   break;
	   case 2:
		    viewAllProducts();
		   break;
	   case 3:
		   searchAProduct();
		   break;
	   case 4:
		    filterByProductName();
		   break;
	   case 5:
		   filterByProductPrice();
		   break;
	   case 6:
		   filterByProductBrand();
		   break;	
	   case 7:
		   LogOutCurrentUser();
		   break;
	default:
		System.out.println("Thank you for having us!!");
		closeApplication();
	   }
	  }
		
	}


	private static void LogOutCurrentUser() {
	  
		System.out.println("Are you sure do you want to log out? y/n");
		String input=scan.nextLine();
		if(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("Yes"))
		{
			object.logOutCurrentUser();
			isLoggedIn();
		}
		else
		{
			isLoggedIn();
		}
		
	}


	private static void promptLogIn()
	{
	System.out.println("Please Enter UserId:");	
	  String userid=scan.nextLine();
	  System.out.println("Please Enter Password"); 
	  Console c=System.console();
	  String password;
	  if(c!=null)
		  password=String.valueOf(c.readPassword());
	  else
		  password=scan.nextLine();
	   try
	   {
	    if(!object.validateLogIn(userid, password))
	    	System.out.println("Wrong UserName/Password");
	    isLoggedIn();		   
	   }
	   catch(LoginException e)
	   {
		   e.printLog();
		   promptLogIn();
	   }
	  
	}
	
	public static void closeApplication()
	{
	  System.exit(0);	
	}
	
	public static UserDTO getUserDTO()
	{
		System.out.print("\nEnter UserId:");
		String userid=scan.nextLine();
		System.out.print("\nEnter password:");
		Console c=System.console();
		  String password;
		  if(c!=null)
			  password=String.valueOf(c.readPassword());
		  else
			  password=scan.nextLine();
		System.out.print("\nEnter PhoneNumber:");
		String phone=scan.nextLine();
		System.out.print("\nEnter Email:");
		String email=scan.nextLine();
	   return new UserDTO(userid,password,phone,email,"ProductMaster",new AddressDTO(GenerateRandomString.getAlphaNumericString(),"101","B1001","Dharmavaram","Andhra Pradesh","india","515671"));
	}
	
}
