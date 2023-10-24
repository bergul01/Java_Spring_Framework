package kodlamaio.northwind.api.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlamaio.northwind.business.abstracts.UserService;
import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utilities.results.ErrorDataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import org.springframework.validation.FieldError;

@RestController
@RequestMapping(value="/api/users")
public class UsersController {

	 
	private UserService userService;
	
	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping(value ="/add")
	public ResponseEntity<?> add(@Valid @RequestBody User user) { //ResponseEntity<Result> olucak normalde ama her zaman result 
		//9.video 2.35.00 dan sonrasını izleyeblirsin anlamadıysan 
		return ResponseEntity.ok(this.userService.add(user));  
		
		/*
		 * database kısmına postmandan post seçip http://localhost:8080/api/users/add
		 *dediğimiz zaman bad request alıyorum bundan hata almamak için bu işlemin bir post işlemi olduğu için 
		 *body kısmına girerek database kısmına ekleme yapılcak yerleri burada el ile giricez örnek olarak şu an 
		 *databasede olan kısmı şu şekilde girdim :  {
			"id":"1",
			"email":"bergul1907@hotmail.com",
			"password":"123456"

			}
		  */
		//postmande id boş bırakılabilir fakat email ve password kısmını "" boş bırakırsak sistem uyarı vericek olup
		//email ve password kısmını boş bırakılmicağını söylicektir
		//email kısmına "1" diye bir değer girdiğimizde tekrardan sistem uyarı vericektir düzgün biçimli bir e-posta adresi değil!
		//bu kısımlar user kısmında ve userController ksımında exceptionHandler ile yaptık ezberlemeye gerek yok
	}
		
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object>handleValidationException
	(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors = new HashMap<String,String>();
		
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama hatalari");
		
		return errors;
	}
		
		
		
	//veri olarak ne dönmek gerek
	//api toning 
	
	
}
