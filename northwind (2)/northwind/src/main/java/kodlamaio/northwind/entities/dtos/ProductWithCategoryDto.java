package kodlamaio.northwind.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithCategoryDto {
//DTO nedir ? https://medium.com/@latestsoftwaredevelopers/dto-nedir-ne-işe-yarar-8f01c9e7bba7
	
	private int id;
	private String productName;
	private String categoryName;
	
	
	
	
	
	
}
