package com.capgemini.greatoutdoors.util;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.greatoutdoors.dto.AddressDTO;
import com.capgemini.greatoutdoors.dto.UserDTO;

public class AdminCredentialsRepository 
{
    
	static Map<String,UserDTO> adminData=new HashMap<>();

	static {
		adminData.put("aravind4532", new UserDTO("aravind4532","123","9866772522","aravind4532@gmail.com","Admin",new AddressDTO(GenerateRandomString.getAlphaNumericString(),"101","B1001","Dharmavaram","Andhra Pradesh","india","515671")));
	}
	public static Map<String, UserDTO> getAdminData() {
		return adminData;
	}

	
	
	
}
