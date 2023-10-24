package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
		DataResult<List<Product>> getAll();
		
		//paging(sayfalama) 100 sayfalık bir yerde istenilen page number ksımına kadar çekilmesini sağlicak
		DataResult<List<Product>> getAll(int pageNo, int pageSize);//manager kısmında kodlarken bu methodu hata aldım
		
		
		DataResult<List<Product>> getAllSortedDesc(); //Z-A ya doğru verileri sıralar 
		
		DataResult<List<Product>> getAllSortedAsc(); //A-Z ya doğru verileri sıralar
		
		Result add(Product product);
	
		DataResult<Product> getByProductName(String productName); 
		
		
		DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);
		
		
		DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);
		
		
		DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);
		
		DataResult<List<Product>> getByProductNameContains(String productName); 
		
		DataResult<List<Product>> getByProductNameStarsWith(String productName);
			
		DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
	
		DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
	
}
