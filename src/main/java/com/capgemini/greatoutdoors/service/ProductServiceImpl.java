package com.capgemini.greatoutdoors.service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.capgemini.greatoutdoors.dao.ProductDaoImpl;
import com.capgemini.greatoutdoors.dto.ProductDTO;
import com.capgemini.greatoutdoors.exceptions.ProductException;


public class ProductServiceImpl implements ProductService{

	ProductDaoImpl productDao;
	
	public ProductServiceImpl()
	{
	 productDao=new ProductDaoImpl();	
	}
	
	
	@Override
	public Map<String, ProductDTO> viewAllProducts() throws ProductException {
		
       try
       {
    	  Map<String,ProductDTO> map=productDao.viewAllProducts(); 
    	  
    	  return map;
       }
       catch(ProductException e)
       {
    	   throw e;
       }
	}

	@Override
	public boolean addProduct(ProductDTO product) throws ProductException {
		
		try
		{
			productDao.addProduct(product);
			return true;
		}
		catch(ProductException e)
		{
		   throw e;	
		}
		
		
	}

	@Override
	public boolean editProduct(ProductDTO product) throws ProductException {
		
		try
		{
			productDao.editProduct(product);
			return true;
		}
		catch(ProductException e)
		{
		  throw e;	
		}
	}

	@Override
	public boolean deleteProduct(String productId) throws ProductException {
	
		try
		{
		 productDao.deleteProduct(productId);
		 return true;
		}
		catch(ProductException e)
		{
			throw e;
		}
	}


	@Override
	public Map<String,ProductDTO> filterProducts(int input,Map<String,ProductDTO> list)throws ProductException
	{
		switch(input)
		{
		  case 1:
			return filterByName(list);
		  case 2:
			  return filterByBrand(list);
		  case 3:
			 return filterByBrand(list);
	      default:
	    	  return null;
		}
	}


	@Override
	public Map<String,ProductDTO> filterByName(Map<String,ProductDTO> input)throws ProductException
	{
		Collection<ProductDTO> list=null;	
	  if(input!=null)
	  {
	    list=input.values();
	  }
	  else
	  {
	   list=viewAllProducts().values();
	   if(list==null)
		   throw new ProductException("No Elements in Repository");
	  } 
      List<ProductDTO> output=list.stream().sorted((a,b)->a.getProductName().compareToIgnoreCase(b.getProductName())).collect(Collectors.toList());
	    
		Map<String,ProductDTO> o = new LinkedHashMap<String,ProductDTO>();
	    
	    for(ProductDTO p:output)
	    {
	     o.put(p.getProductId(), p);	
	    }
	    
	    return o;
	}


	@Override
	public Map<String,ProductDTO> filterByPrice(Map<String,ProductDTO> input) throws ProductException
	{
		Collection<ProductDTO> list=null;	
		  if(input!=null)
		  {
		    list=input.values();
		  }
		  else
		  {
		   list=viewAllProducts().values();
		   if(list==null)
			   throw new ProductException("No Elements in Repository");
		  } 
      List<ProductDTO> output=list.stream().sorted((a,b)->(a.getPrice()>b.getPrice())?1:-1).collect(Collectors.toList());
	    
		Map<String,ProductDTO> o = new LinkedHashMap<String,ProductDTO>();
	    
	    for(ProductDTO p:output)
	    {
	     o.put(p.getProductId(), p);	
	    }
	    
	    return o;
	}


	@Override
	public Map<String,ProductDTO> filterByBrand(Map<String,ProductDTO> input)throws ProductException
	{
        
		Collection<ProductDTO> list=null;	
		  if(input!=null)
		  {
		    list=input.values();
		  }
		  else
		  {
		   list=viewAllProducts().values();
		   if(list==null)
			   throw new ProductException("No Elements in Repository");
		  } 
		List<ProductDTO> output=list.stream().sorted((a,b)->a.getProductBrand().compareToIgnoreCase(b.getProductBrand())).collect(Collectors.toList());
	    
		Map<String,ProductDTO> o = new LinkedHashMap<String,ProductDTO>();
	    
	    for(ProductDTO p:output)
	    {
	     o.put(p.getProductId(), p);	
	    }
	    
	    return o;
	}


	@Override
	public Map<String, ProductDTO> searchAProduct(String input) throws ProductException {
		
		Map<String,ProductDTO> out=new HashMap<String,ProductDTO>();
		
		List<ProductDTO> output=productDao.viewAllProducts().values().stream().filter(p->
		 {
			if(p.getProductName().toLowerCase().contains(input.toLowerCase()) || p.getProductBrand().toLowerCase().contains(input.toLowerCase()) || p.getProductId().contains(input.toLowerCase()) || p.getSpecification().toLowerCase().contains(input.toLowerCase()) )
				return true;
			else
				return false;
                			
		}).collect(Collectors.toList());
		if(output.size()==0 || output==null)
			throw new ProductException("No Such Product Exist !!");
		else
		{
			for(ProductDTO po:output)
				out.put(po.getProductId(), po);
	     return out;
		}
	}
	
	

}
