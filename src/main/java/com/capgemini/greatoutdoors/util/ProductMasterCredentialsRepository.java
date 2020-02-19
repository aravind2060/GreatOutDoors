package com.capgemini.greatoutdoors.util;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.greatoutdoors.dto.AddressDTO;
import com.capgemini.greatoutdoors.dto.UserDTO;

public class ProductMasterCredentialsRepository 
{
   static Map<String,UserDTO> ProductMasterMap=new HashMap<>();
   static
   {
		ProductMasterMap.put("sai12", new UserDTO("sai12","123","9866772522","aravind4532@gmail.com","Admin",new AddressDTO(GenerateRandomString.getAlphaNumericString(),"101","B1001","Dharmavaram","Andhra Pradesh","india","515671")));
   }
   public static void setDataIntoRepository(UserDTO user)
   {
	  ProductMasterMap.put(user.getUserId(), user);  
   }
   public static Map<String,UserDTO> getDataFromRepository()
   {
	   return ProductMasterMap;
   }
  
}
