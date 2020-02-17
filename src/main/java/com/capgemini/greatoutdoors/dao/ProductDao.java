package com.capgemini.greatoutdoors.dao;


import java.util.List;
import java.util.Map;

import com.capgemini.greatoutdoors.dto.ProductDTO;
import com.capgemini.greatoutdoors.exceptions.ProductException;

public interface ProductDao {

	Map<String, ProductDTO> viewAllProducts()throws ProductException;
	boolean addProduct(ProductDTO product)throws ProductException;
	boolean editProduct(ProductDTO product)throws ProductException;
	boolean deleteProduct(String productId)throws ProductException;
	List<ProductDTO> filterProducts();
	List<ProductDTO> filterByName();
	List<ProductDTO> filterByPrice();
	List<ProductDTO> filterByBrand();
	
}
