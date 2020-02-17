package com.capgemini.greatoutdoors.dao;


import java.util.List;
import java.util.Map;

import com.capgemini.greatoutdoors.dto.ProductDTO;
import com.capgemini.greatoutdoors.exceptions.ProductException;
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
			else {
			return productsList;
		}
	}

	
	public boolean addProduct(ProductDTO product) throws ProductException
	{
		if(productsList.containsValue(product))
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
		productsList.put(product.getProductId(), product);
		editInDb(product);
		return true;
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


	@Override
	public List<ProductDTO> filterProducts() {
		
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
		
		return null;
	}

}
