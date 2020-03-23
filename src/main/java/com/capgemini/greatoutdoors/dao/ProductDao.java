package com.capgemini.greatoutdoors.dao;



import java.util.Map;

import com.capgemini.greatoutdoors.dto.ProductDTO;
import com.capgemini.greatoutdoors.dto.UserDTO;
import com.capgemini.greatoutdoors.exceptions.LoginException;
import com.capgemini.greatoutdoors.exceptions.ProductException;

public interface ProductDao {

	Map<String, ProductDTO> viewAllProducts()throws ProductException;
	boolean addProduct(ProductDTO product)throws ProductException;
	boolean editProduct(ProductDTO product)throws ProductException;
	boolean deleteProduct(String productId)throws ProductException;
	Map<String,ProductDTO> filterByName(String input)throws ProductException;
	Map<String,ProductDTO> filterByPrice()throws ProductException;
	Map<String,ProductDTO> filterByBrand(String input)throws ProductException;
	Map<String, ProductDTO> searchAProduct(String input) throws ProductException;
	boolean validateAdminLogIn(String username,String password);
	boolean validateProductMasterLogIn(String username,String password)throws LoginException;
	void logOutCurrentUser();
	void createProductMaster(UserDTO user);
	
}
