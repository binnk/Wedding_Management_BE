package home.javaweb.converter;

import org.springframework.stereotype.Component;

import home.javaweb.dto.FoodDTO;
import home.javaweb.entity.Food;

@Component
public class FoodConverter {
	
	public FoodDTO toDTO(Food entity) {
		FoodDTO result = new FoodDTO();
		
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setPrice(entity.getPrice());
		result.setImg(entity.getImg());
		result.setCategory(entity.getFoodCategory());
		result.setMoreInfo(entity.getMoreInfo());

		return result;
	}
	
	public Food toEntity(FoodDTO dto) {
		Food result = new Food();
		
		result.setId(dto.getId());
		result.setName(dto.getName());
		result.setPrice(dto.getPrice());
		result.setImg(dto.getImg());
		result.setFoodCategory(dto.getCategory());
		result.setMoreInfo(dto.getMoreInfo());
		
		return result;
	}
}
