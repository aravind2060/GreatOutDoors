package com.capgemini.greatoutdoors.service;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import com.capgemini.greatoutdoors.dto.ProductDTO;
import com.capgemini.greatoutdoors.exceptions.ProductException;
import com.capgemini.greatoutdoors.util.ProductsRepository;


public class TestProductServiceImpl {

	
	ProductServiceImpl object=new ProductServiceImpl();
	
	@DisplayName("Testing Adding functionality of product into Repository")
	@Test
	public void testAddaProduct()
	{
		
	   assertAll("Testing insertion ",
			   ()->assertEquals("test1 insertion",true,object.addProduct(new ProductDTO("id3",120.12,"Pink","Dimen1","Spec1","manu1",120,2,"Product1","Puma"))),
			   ()->assertEquals("test2 insertion",true,object.addProduct(new ProductDTO("id4",120.12,"Pink","Dimen1","Spec1","manu1",120,2,"Product1","Puma"))),
			   ()->Assertions.assertThrows(ProductException.class,()->object.addProduct(new ProductDTO("id1",120.12,"Pink","Dimen1","Spec1","manu1",120,2,"Product1","Puma"))),
			   ()->Assertions.assertThrows(ProductException.class,()->object.addProduct(null)));
	
	}
	@DisplayName("Testing Editing functionality of product into Repository")
	@Test
	public void testEditaProduct()
	{
		
		 assertAll("Testing Updation ",
				   ()->assertEquals("test1 updation",true,object.editProduct(new ProductDTO("id3",120.12,"Pink","Dimen1","Spec1","manu1",120,2,"Product1","Puma"))),
				   ()->assertEquals("test2 updation",true,object.editProduct(new ProductDTO("id4",120.12,"Pink","Dimen1","Spec1","manu1",120,2,"Product1","Puma"))),
				   ()->Assertions.assertThrows(ProductException.class,()->object.editProduct(new ProductDTO("id5",120.12,"Pink","Dimen1","Spec1","manu1",120,2,"Product1","Puma"))),
				   ()->Assertions.assertThrows(ProductException.class,()->object.editProduct(null)));
	}
	@DisplayName("Testing deleting functionality of product into Repository")
	@Test
	public void testDeleteaProduct()
	{
	
		 assertAll("Testing Deletion ",
				   ()->assertEquals("test1 deletion",true,object.editProduct(new ProductDTO("id1",120.12,"Pink","Dimen1","Spec1","manu1",120,2,"Product1","Puma"))),
				   ()->assertEquals("test2 deletion",true,object.editProduct(new ProductDTO("id2",120.12,"Pink","Dimen1","Spec1","manu1",120,2,"Product1","Puma"))),
				   ()->Assertions.assertThrows(ProductException.class,()->object.editProduct(new ProductDTO("id3",120.12,"Pink","Dimen1","Spec1","manu1",120,2,"Product1","Puma"))),
				   ()->Assertions.assertThrows(ProductException.class,()->object.editProduct(null)));
	}
	
	@DisplayName("Testing viewAll functionality of product into Repository")
	@Test
	public void testViewAllProducts()
	{
	
		Map<String, ProductDTO> map=ProductsRepository.getProductRepository();
		
		
		assertAll("Testing ViewAll Products ",()->assertEquals(map,object.viewAllProducts()));
	}
	
	@DisplayName("Testing Search functionality of product into Repository")
	@Test
	public void testSearchaProduct() throws ProductException
	{
		Map<String, ProductDTO> map=object.viewAllProducts();
		List<ProductDTO> output=map.values().stream().
				filter(p->
				p.getProductName().toLowerCase().contains("puma") || p.getProductBrand().toLowerCase().contains("puma") || p.getProductId().contains("puma") || p.getSpecification().toLowerCase().contains("puma")
		         ).collect(Collectors.toList());
		
		Collection<ProductDTO> originalout=object.searchAProduct("puma").values();
		//System.out.println(output+"\noriginal\n"+originalout+"\nhety\n"+output.containsAll(originalout));
		 assertAll("Testing Search ",
				   ()->assertEquals("test1 search",true,output.containsAll(originalout)));
	}
	
	
	@DisplayName("Testing filterByName functionality of product into Repository")
	@Test
	public void testFilterByName() throws ProductException
	{
		Map<String,ProductDTO> inputmap=object.viewAllProducts();
		List<ProductDTO> list=inputmap.entrySet().stream().filter(p->p.getValue().getProductName().contentEquals("Product1")).map(p->p.getValue()).collect(Collectors.toList());
		Collection<ProductDTO> list2=object.filterByName("Product1").values();
		assertAll("Testing Filter by Name",()->assertEquals(true,list.containsAll(list2)),()->Assertions.assertThrows(ProductException.class, ()->object.filterByName("Product100")));
	}
	
	@DisplayName("Testing filterByBrand functionality of product into Repository")
	@Test
	public void testFilterByBrand() throws ProductException
	{
		Map<String,ProductDTO> inputmap=object.viewAllProducts();
		List<ProductDTO> list=inputmap.values().stream().filter(p->p.getProductBrand().contentEquals("Puma")).collect(Collectors.toList());
		Collection<ProductDTO> list2=object.filterByBrand("Puma").values();
		assertAll("Testing Filter by Brand",()->assertEquals(true,list.containsAll(list2)),()->Assertions.assertThrows(ProductException.class, ()->object.filterByBrand("Product100")));
	}
	@DisplayName("Testing filterByPrice functionality of product into Repository")
	@Test
	public void testFilterByPrice() throws ProductException
	{
		Map<String,ProductDTO> inputmap=object.viewAllProducts();
		List<ProductDTO> list=inputmap.entrySet().stream().map(p->p.getValue()).sorted((a,b)->(a.getPrice()>b.getPrice())?1:-1).collect(Collectors.toList());
		Collection<ProductDTO> list2=object.filterByPrice().values();
		assertAll("Testing Filter by price",()->assertEquals(true,list.containsAll(list2)));
	}
	
	
	
	
	
}
