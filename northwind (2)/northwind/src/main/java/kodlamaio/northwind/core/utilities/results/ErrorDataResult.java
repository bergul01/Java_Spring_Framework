package kodlamaio.northwind.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {

	public ErrorDataResult(T data, String message) { //dataResult sınıfında ki constructer a göre yaptık
		super(data, false, message);
	}
	
	public ErrorDataResult(T data) { //sadece data verilen parametre
		super(data,false);
	}
	public ErrorDataResult( String message) { //sadece mesaj verilen parametre 
		super(null, false, message);
	}
	public ErrorDataResult() { //hiç data verilmezse null ve false döndürür
		super(null, false);
	}
	
	
	
}
