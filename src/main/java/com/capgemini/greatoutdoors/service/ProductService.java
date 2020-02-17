package com.capgemini.greatoutdoors.service;


import java.util.Map;

import com.capgemini.greatoutdoors.dto.ProductDTO;
import com.capgemini.greatoutdoors.exceptions.ProductException;

public interface ProductService {

	Map<String,ProductDTO> viewAllProducts()throws ProductException;
	boolean addProduct(ProductDTO product)throws ProductException;
	boolean editProduct(ProductDTO prodcut)throws ProductException;
	boolean deleteProduct(String productId)throws ProductException;
	Map<String,ProductDTO> filterProducts(int input,Map<String,ProductDTO> list)throws ProductException;
	Map<String,ProductDTO> filterByName(Map<String,ProductDTO> list)throws ProductException;
	Map<String,ProductDTO> filterByPrice(Map<String,ProductDTO> list)throws ProductException;
	Map<String,ProductDTO> filterByBrand(Map<String,ProductDTO> list)throws ProductException;
	Map<String,ProductDTO> searchAProduct(String input)throws ProductException;
   
	
}
