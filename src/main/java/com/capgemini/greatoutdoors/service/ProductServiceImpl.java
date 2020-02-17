package com.capgemini.greatoutdoors.service;


import java.util.List;
import java.util.Map;
import com.capgemini.greatoutdoors.dao.ProductDaoImpl;
import com.capgemini.greatoutdoors.dto.ProductDTO;
import com.capgemini.greatoutdoors.exceptions.ProductException;

public class ProductServiceImpl implements ProductService{

	ProductDaoImpl productDao;
	
	ProductServiceImpl()
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
	public List<ProductDTO> filterProducts() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ProductDTO> filterByName() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ProductDTO> filterByPrice() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ProductDTO> filterByBrand() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
