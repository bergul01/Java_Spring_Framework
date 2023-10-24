package kodlamaio.northwind.entities.concretes;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class Category {
	@Id
	@Column(name = "category_id")
	private int categoryId;
	
	@Column(name = "category_Name")
	private String categoryName;

	@OneToMany(mappedBy = "category") //category ana tablomuz 
	private List<Product> products;		//mappedBy : product categories tablosuyla ilişkilendirildi anlamına gelmektedir
										//category one , product tablosu many olarak ayarladık 
	
	
	
	
}
