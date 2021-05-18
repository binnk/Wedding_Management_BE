package home.javaweb.service;

import java.util.List;

import home.javaweb.dto.FoodDTO;

public interface IFoodService {
	List<FoodDTO> findAll();
}
