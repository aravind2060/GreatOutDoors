package com.capgemini.greatoutdoors.util;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.greatoutdoors.dto.ProductDTO;

public class ProductsRepository {

	static Map<String,ProductDTO> ProductRepo=new HashMap<String,ProductDTO>(); 
	 public ProductsRepository()
	{
		
	}
	public static void  setProductsRepository()
	{
	 ArrayList<String> productIds=new ArrayList<>();
	 List<String> productNames=Arrays.asList("Product1","Product2","Product3","Product4","Product5","Product6");
	 List<Double> productPrices=Arrays.asList(120.0,123.56,782.56,789.23,456.21,987.21);
	 List<String> productColours=Arrays.asList("Red","Pink","Green","Yellow","Orange","Blue");
	 List<String> productDimensions=Arrays.asList("dimension1","dimension2","dimension3","dimension4","dimension5","dimension6");
	 List<String> productSpecifications=Arrays.asList("spec1","spec2","spec3","spec4","spec5","spec6");
	 List<String> productManufacturers=Arrays.asList("manfacturer1","manfacturer2","manfacturer3","manfacturer4","manfacturer5","manfacturer6");
	 List<Integer> productQuantites=Arrays.asList(12,10,100,120,50,60);
	 List<Integer> productCategories=Arrays.asList(1,2,3,4,5,2);
	 List<String> productBrands=Arrays.asList("Nike","Puma","adiddas","safari","Red Bull","Go pro");
	 
	 for(int i=0;i<6;i++)
		 productIds.add(GenerateRandomString.getAlphaNumericString());
	 
	 for(int i=0;i<6;i++)
		 ProductRepo.put(productIds.get(i),new ProductDTO(productIds.get(i),productPrices.get(i),productColours.get(i),productDimensions.get(i),productSpecifications.get(i),
				 productManufacturers.get(i),productQuantites.get(i),productCategories.get(i),productNames.get(i),productBrands.get(i)));
	  
	}
	
	public static Map<String,ProductDTO> getProductRepository()
	{
		return ProductRepo;
	}
	
	public static void addingaProductByProductMaster(ProductDTO product)
	{
		ProductRepo.put(product.getProductId(), product);
	}
	
	public static void editaProductByProductMaster(ProductDTO product)
	{
		ProductRepo.put(product.getProductId(), product);
	}
	
	public static void deleteaProductByProductMaster(String key)
	{
		ProductRepo.remove(key);
	}
}
