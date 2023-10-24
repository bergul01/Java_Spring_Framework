package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

@RestController //springen geliyor api controller olduğunu söyledik yani androidte ios ta seninle iletişimde bulunabilir
@RequestMapping("/api/products") //ana kök domainin yazdık // dış dünyadan kodlama.io/api/products gibi bir istek gelirse bu kod karşılıcak
public class ProductsController {
	
	//@Autowired desek aslında constructer e gerek kalmaz tek bir service bu örnekte tek servis mesela ama birden fazla olursa hepsinin başına @AutoWider koymamız gerek onun yerine constructer yapabiliriz source kısmından
	private ProductService productService;
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}
//Spring MVC’nin, HTTP metod tiplerine göre özelleştirilmiş @GetMapping, @PostMapping, @DeleteMapping, @PutMapping, @PatchMapping gibi anotastonları vardır. 

	@GetMapping("/getAll") //kodlama.io/api/products/getall  diye bir istekte bulunursam aşağıda yazılan kod karşılicak ve çalışıcak //postmande get ile çekilcek
	public DataResult<List<Product>> getAll(){ //Product tablosunda tüm verileri dönecek metot yazdık //metot yazdık manuel olarak database kısmından tüm veriyi çekicek
		return this.productService.getAll();
	}
	
//	@PostMapping("/add") //postman de post ile çekicez 
//	public Result add(Product product){
//		return new Result(true,"urun eklendi");
//	}
	
	@PostMapping("/add") //postman de post ile çekicez 
	public Result add(@RequestBody Product product) {   //@RequestBody bize girilen dataları doğru yerlere match etmeye yarar
		return this.productService.add(product);
	}
	
	
	// *getByProdcutName kısmında bir düzeltme yaptım başına / eklendi kod çalışmassa burada ara 
	//http://localhost:8080/api/products/getByProductName?productName=Pavlova 
	//yukarda ki url den postman e girildiğinde değeri getiriyor veritabanından fakat Berkay ismini girdiğimde
	//veritabanında 2 adet berkay olduğundan query did not return a unique result: 2 bu hatayı atıyor.
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		//@RequestParam --> yapılan isteğin parametrelerine bak productName diye bir şey olucak bunu productName içine ata ve bize göstermesini sağlıyor
		return this.productService.getByProductName(productName);
	}
	
	
	//http://localhost:8080/api/products/getByProductNameAndCategoryId?productName=Chai&categoryId=1
	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam String productName, @RequestParam int categoryId ){
		
		return this.productService.getByProductNameAndCategoryId(productName, categoryId);
		 
	}
	
	//localhost:8080/api/products/getByProductNameContains?productName=ab
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		
		return this.productService.getByProductNameContains(productName);
	}
	
	//localhost:8080/api/products/getAllDesc
	@GetMapping("/getAllDesc")
	public DataResult<List<Product>> getAllSortedDesc(){
		//databaseden çektiğimiz verilerin hepsini Z-A ya doğru sıralar tam tersi şekilde
		
		return this.productService.getAllSortedDesc();
	}
	
	//localhost:8080/api/products/getAllAsc
	@GetMapping("/getAllAsc ")
	public DataResult<List<Product>> getAllSortedAsc(){
		// databaseden çektiğimiz verilerin hepsini A-Z ye doğru sıralar.
		
		return this.productService.getAllSortedAsc();
	}
	//localhost:8080/api/products/getProductWithCategoryDetails
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetals(){
		//dto gerçekleştirdik  
		return this.productService.getProductWithCategoryDetails();
	}
	
	//postman'de post /api/products/add dediğimiz zaman bad request 400 hatasını alıyoruz bunun için 
	//body -> raw ->JSON -> diyip body kısmında ürün girişi yapmamız gerekir
	
}