package home.javaweb.service;

import java.util.List;

import home.javaweb.dto.FoodDTO;

public interface IFoodService {
	List<FoodDTO> findAll();
	FoodDTO save(FoodDTO dto);
	FoodDTO findById(Long id);
	void deleteById(Long[] ids);
}
