package com.capgemini.greatoutdoors.util;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.greatoutdoors.dto.ProductDTO;

public class ProductsRepository {

	static Map<String,ProductDTO> ProductRepo=new HashMap<String,ProductDTO>(); 
 static
	{
	 ArrayList<String> productIds=new ArrayList<>();
	 List<String> productNames=Arrays.asList("Product1","Product2","Product3","Product4","Product5","Product6","Product7","Product8","Product9","Product10");
	 List<Double> productPrices=Arrays.asList(120.0,123.56,782.56,789.23,456.21,987.21,152.23,182.0,195.2,198.25);
	 List<String> productColours=Arrays.asList("Red","Pink","Green","Yellow","Orange","Blue","Green","Yellow","Orange","Blue");
	 List<String> productDimensions=Arrays.asList("dimension1","dimension2","dimension3","dimension4","dimension5","dimension6","dimension7","dimension8","dimension9","dimension10");
	 List<String> productSpecifications=Arrays.asList("spec1","spec2","spec3","spec4","spec5","spec6","spec7","spec8","spec9","spec10");
	 List<String> productManufacturers=Arrays.asList("manfacturer1","manfacturer2","manfacturer3","manfacturer4","manfacturer5","manfacturer6","manfacturer7","manfacturer8","manfacturer9","manfacturer10");
	 List<Integer> productQuantites=Arrays.asList(12,10,100,120,50,60,100,120,50,60);
	 List<Integer> productCategories=Arrays.asList(1,2,3,4,5,2,2,3,4,5,2);
	 List<String> productBrands=Arrays.asList("Nike","Puma","adiddas","safari","Red Bull","Go pro","Puma","Puma","Puma","Puma");
	 
	 productIds.add("id1");
	 productIds.add("id2");
	 for(int i=2;i<10;i++)
		 productIds.add(GenerateRandomString.getAlphaNumericString());
	 
	 for(int i=0;i<10;i++)
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
