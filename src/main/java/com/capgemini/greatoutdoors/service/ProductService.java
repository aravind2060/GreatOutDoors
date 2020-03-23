package com.capgemini.greatoutdoors.service;


import java.util.Map;

import com.capgemini.greatoutdoors.dto.ProductDTO;
import com.capgemini.greatoutdoors.dto.UserDTO;
import com.capgemini.greatoutdoors.exceptions.LoginException;
import com.capgemini.greatoutdoors.exceptions.ProductException;

public interface ProductService {

	Map<String,ProductDTO> viewAllProducts()throws ProductException;
	boolean addProduct(ProductDTO product)throws ProductException;
	boolean editProduct(ProductDTO prodcut)throws ProductException;
	boolean deleteProduct(String productId)throws ProductException;
	Map<String,ProductDTO> filterByName(String input)throws ProductException;
	Map<String,ProductDTO> filterByPrice()throws ProductException;
	Map<String,ProductDTO> filterByBrand(String input)throws ProductException;
	Map<String,ProductDTO> searchAProduct(String input)throws ProductException;
    boolean checkUserLoggedIn();
    boolean checkWhoLoggedIn();
    boolean createProductMaster(UserDTO user);
    boolean validateLogIn(String username,String password)throws LoginException;
    void logOutCurrentUser();
	
}
