package home.javaweb.service;

import java.util.List;

import home.javaweb.entity.FoodCategory;

public interface IFoodCategoryService {
	List<FoodCategory> findAll();
	
	FoodCategory save(FoodCategory newCategory);
	
	FoodCategory get(Long id);
	
	void deleteById(Long[] ids);
	
}
