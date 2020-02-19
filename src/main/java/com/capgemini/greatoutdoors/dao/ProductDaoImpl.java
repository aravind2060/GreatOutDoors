package com.capgemini.greatoutdoors.dao;


import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.capgemini.greatoutdoors.dto.ProductDTO;
import com.capgemini.greatoutdoors.dto.UserDTO;
import com.capgemini.greatoutdoors.exceptions.LoginException;
import com.capgemini.greatoutdoors.exceptions.ProductException;
import com.capgemini.greatoutdoors.util.AdminCredentialsRepository;
import com.capgemini.greatoutdoors.util.CurrentUserInfo;
import com.capgemini.greatoutdoors.util.ProductMasterCredentialsRepository;
import com.capgemini.greatoutdoors.util.ProductsRepository;

public class ProductDaoImpl implements ProductDao
{
    Map<String, ProductDTO> productsList;
    public ProductDaoImpl()
    {
 
       this.productsList=ProductsRepository.getProductRepository();
    }
    
    
	public Map<String, ProductDTO> viewAllProducts() throws ProductException
	{
		if(productsList.isEmpty())
		{
			throw new ProductException("No  Products Exist");
		}
		else 
		{
			/*
			 * if it is real project we will limit no.of returning results
			 * 
			 */
			return productsList;
		}
	}

	
	public boolean addProduct(ProductDTO product) throws ProductException
	{
		if(productsList.containsKey(product.getProductId()))
			 throw new ProductException("Product Already Exist");
		else
		{
			productsList.put(product.getProductId(), product);
			addIntoDb(product);
			return true; 
		}
		
	}

	
	public boolean editProduct(ProductDTO product) throws ProductException 
	{
		if(productsList.containsKey(product.getProductId()))
		{
			productsList.put(product.getProductId(), product);
			return true;
		}	 
		else
		{
		 throw new ProductException("There is no such product to edit!!");
		}
	}

	public boolean deleteProduct(String productId) throws ProductException 
	{
	   if(productsList.containsKey(productId))
	   {
		   productsList.remove(productId);
		   deleteInDb(productId);
		   return true;
	   }
	   else
	   {
		   throw new ProductException("No Such Product Exist!");   
	   }
		
	}
	
	
	public void addIntoDb(ProductDTO product)
	{
		ProductsRepository.addingaProductByProductMaster(product);
	}
	
	public void deleteInDb(String productId)
	{
	  ProductsRepository.deleteaProductByProductMaster(productId);	
	}
	
	public void editInDb(ProductDTO product)
	{
		ProductsRepository.editaProductByProductMaster(product);
	}




	public boolean validateAdminLogIn(String username,String password)
	{
		Map<String,UserDTO> admindata=AdminCredentialsRepository.getAdminData();
		if(admindata.containsKey(username))
		{
			 return admindata.get(username).getPassword().contentEquals(password);
		}
		return false;
	}
	
	public boolean validateProductMasterLogIn(String username,String password)throws LoginException
	{
		Map<String,UserDTO> productMasterData=ProductMasterCredentialsRepository.getDataFromRepository();
		
		if(productMasterData.isEmpty())
			throw new LoginException("There are 0 ProductMasters Please create a Product Master.Please Login to Admin and create one!");
		else
		if(productMasterData.containsKey(username))
		{
			return productMasterData.get(username).getPassword().contentEquals(password);
		}
		return false;
	}


	public void logOutCurrentUser() {
		
		CurrentUserInfo.setAnyOneLoggedIn(false);
		CurrentUserInfo.setTypeOfUser(null);
	}


	@Override
	public Map<String, ProductDTO> filterByPrice() throws ProductException {
		Collection<ProductDTO> list;	
		   list=viewAllProducts().values();
		   if(list==null)
			   throw new ProductException("No Elements in Repository");
         List<ProductDTO> output=list.stream().sorted((a,b)->(a.getPrice()>b.getPrice())?1:-1).collect(Collectors.toList());
	    
		Map<String,ProductDTO> o = new LinkedHashMap<>();
	    
	    for(ProductDTO p:output)
	    {
	     o.put(p.getProductId(), p);	
	    }
	    
	    return o;
	}


	@Override
	public Map<String, ProductDTO> filterByBrand(String input) throws ProductException {
		Collection<ProductDTO> list;	
		   list=viewAllProducts().values();
		   if(list==null)
			   throw new ProductException("No Elements in Repository");
		List<ProductDTO> output=list.stream().filter(p->p.getProductBrand().toLowerCase().contentEquals(input.toLowerCase())).collect(Collectors.toList());
	    
		Map<String,ProductDTO> o = new LinkedHashMap<>();
	    for(ProductDTO p:output)
	    {
	     o.put(p.getProductId(), p);	
	    }
	    if(o.isEmpty())
			   throw new ProductException("No Such Thing to Filter!");
		   else
			   return o;
	}



	@Override
	public Map<String, ProductDTO> filterByName(String input) throws ProductException {
		Collection<ProductDTO> list;	
		   list=viewAllProducts().values();
		   if(list==null)
			   throw new ProductException("No Elements in Repository");
	      List<ProductDTO> output=list.stream().filter(p->p.getProductName().toLowerCase().contentEquals(input.toLowerCase())).collect(Collectors.toList());
		    
			Map<String,ProductDTO> o = new LinkedHashMap<>();
		    
		    for(ProductDTO p:output)
		    {
		     o.put(p.getProductId(), p);	
		    }
		   if(o.isEmpty())
			   throw new ProductException("No Such Thing to Filter by brand!");
		   else
			   return o;
	}
	@Override  
     public Map<String, ProductDTO> searchAProduct(String input) throws ProductException
    {
		
           Map<String,ProductDTO> out=new HashMap<>();
		List<ProductDTO> output=viewAllProducts().values().stream().
		filter(p->
		p.getProductName().toLowerCase().contains(input.toLowerCase()) || p.getProductBrand().toLowerCase().contains(input.toLowerCase()) || p.getProductId().contains(input.toLowerCase()) || p.getSpecification().toLowerCase().contains(input.toLowerCase())
         ).collect(Collectors.toList());
		if(output.isEmpty())
			throw new ProductException("No Such Product Exist !!");
		else
		{
			for(ProductDTO po:output)
				out.put(po.getProductId(), po);
	     return out;
		}
	}
	  public void createProductMaster(UserDTO user)
	   {
		   ProductMasterCredentialsRepository.setDataIntoRepository(user); 
	   }
}
