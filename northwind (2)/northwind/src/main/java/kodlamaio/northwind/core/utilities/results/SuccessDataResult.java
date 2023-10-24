package kodlamaio.northwind.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T>{
	//T : data ürün listesi, ürün ,kategori olabilir ne olacağı belli olmadığı için t dedik 

	public SuccessDataResult(T data, String message) { //dataResult sınıfında ki constructer a göre yaptık
		super(data, true, message);
	}
	
	public SuccessDataResult(T data) { //sadece data verilen parametre
		super(data,true);
	}
	public SuccessDataResult( String message) { //sadece mesaj verilen parametre 
		super(null, true, message);
	}
	public SuccessDataResult() { //hiç data verilmezse null ve true döndürür
		super(null, true);
	}
	

}
