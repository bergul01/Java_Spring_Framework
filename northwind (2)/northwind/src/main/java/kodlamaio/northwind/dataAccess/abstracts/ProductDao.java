package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product,Integer>{
	
	//interface interfaceyi extends eder.
/* JpaRepository ne yapıyor verdiğim veri tipi için entity anotasyonu için
yani Product için primary key alanını ne olduğunu bana ver ki bende soruları
 ona göre hazırliyim primary key alanım integer olarak veriyoruz yani(id)  
*/
	//select * from product where product_name = productName
	Product getByProductName(String productName); //import etmemize gerek yok JpaRepository tarafınadn hazır geliyor
												 //isimlendirme kurullarina uyarak getBy veya findAll şeklinde yazabiliriz
	
	//select * from product where product_name = productName and category_id = categoryId
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	
	//select * from product where product_name = productName or category_id = categoryId //birden fazla değer döndürür varsa
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	
	//select * from products where category_id in(1,2,3,...)
	List<Product> getByCategoryIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName); //ürünün içinde içeriyorsa
	
	//List<Product> getByProductNameStarsWith(String productName);// bu isimle başlayanları getir
	
	//Aşağıda @query ile yazdığımız kısımda JPA kullanarak ORM katmanını kullanmış oluyor yani sql kodları yazmıyoruz kodun içine gömmüş oluyoruz
		//"(From Product where product sınıfında ki alan =: parametrede ki productName )"	//(: olması parametrede ki değişkeni kast eder)
	@Query("From Product where productName=:productName and category.categoryId=:categoryId") 
	List<Product> getByNameAndCategory(String productName, int categoryId);
	
	//@query kısmında JPQL yazmış olduk 
	@Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto"
			+ "(p.id,p.productName,c.categoryName) "
			+ "From Category c Inner Join c.products p") 
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
	
	// yukarda @query içinde yapılan JPQL in databasede yazılan sorgusu aşağıdaki gibidir biz burda kısaltıyoruz kod blok:41
	//SELECT p.product_id, p.product_name, c.category_name
	//FROM Categories c INNER JOIN products p 
	//ON c.category_id  = p.category_id 
	
}
