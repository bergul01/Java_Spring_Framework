package kodlamaio.northwind.entities.concretes;

import jakarta.persistence.Column; //@Column import ettik
import jakarta.persistence.Entity; //@Entity import ettik
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;		//@Id import ettik
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;  //@Table import ettik
import lombok.AllArgsConstructor;
import lombok.Data;  //@Data import ettik
import lombok.NoArgsConstructor;

@Data //lombok indirdiğimiz için burda bunu yazarak ve import ederek get ve set kısımlarını yazmamıza gerek kalmadı.
@Entity 	//veri tabanı nesnesi olduğunu söyleriz anotasyon işlemidir bu yani dipnot ekliyoruz spring için diyourz ki product bir entitydir.Entity diyerek veri tabanı nesnesi olduğunu söylüyoruz.
@Table(name = "products")  //veri tabanında hangi tabloya karşılık geliceğini söyleriz veri tabanında bunun karşılığı products tobla olarak adı products
@AllArgsConstructor //parametresi olan constructor
@NoArgsConstructor //boş parametreli constructor
public class Product {
	@Id //primary key olduğu 
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //id kısmının 1er 1er artırılmasını sağlar otomatik olarak
	@Column(name = "product_id")	 //veri tabanında hangi kolona karşılık geliyor sutün
	private int id;
	
//	@Column(name = "category_id")  	private Category category; bu kod iki satır kodun yerini tutar 
//	private int categoryId;
	
	@Column(name = "product_name")	
	private String productName;
	
	@Column(name = "unit_price")	
	private double unitPrice; 
	
	@Column(name = "units_in_stock")	
	private short unitsInStock;
	
	@Column(name = "quantity_per_unit")	
	private String quantityPerUnit;
	
	@ManyToOne() //product tablosundan category tablosuna ManyToOne 
	@JoinColumn(name = "category_id")//category anatablo postgreye bakarsak category tablosunda product göremiyoruz o yüzden burda product join ediyoruz
	private Category category; // ilişkili olduğu tabloyla ilişkisi 
	

	
}
