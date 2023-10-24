package kodlamaio.northwind.core.utilities.results;

public class Result { //super type //interface gibi soyut görevi görüyor interface olarak tanımlamadık ama 

	private boolean success; //başarılı mı ? 
	private String message;
	
	public Result(boolean success) {
		this.success=success;
	}
	public Result(boolean success, String message) {
		this(success); //this.succes = success yerini tutar //yukarda ki constructor çağırır.
		this.message = message;
	}
	
	public boolean isSuccess() {
		return this.success;
	}
	public String getMessage() {
		return this.message;
	}
	
	
	
	
}
