package home.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.converter.FoodConverter;
import home.javaweb.dto.FoodDTO;
import home.javaweb.entity.Food;
import home.javaweb.repository.FoodRepository;
import home.javaweb.service.IFoodService;

@Service
public class FoodService implements IFoodService {

	@Autowired
	private FoodRepository foodRepo;
	
	@Autowired
	private FoodConverter foodConverter;
	
	@Override
	public List<FoodDTO> findAll() {
		List<FoodDTO> result = new ArrayList<FoodDTO>();
		List<Food> foods = foodRepo.findAll();
		
		for(Food food : foods) {
			FoodDTO foodDTO = foodConverter.toDTO(food);
			result.add(foodDTO);
		}
		return result;
	}

	@Override
	public FoodDTO save(FoodDTO dto) {
		
		Food food = foodConverter.toEntity(dto);
		foodRepo.save(food);
		
		FoodDTO result = foodConverter.toDTO(food);
		
		return result;
	}

	@Override
	public FoodDTO findById(Long id) {
		Food food = foodRepo.findById(id).get();	
		return foodConverter.toDTO(food);
	}

	@Override
	public void deleteById(Long[] ids) {
		// TODO Auto-generated method stub
		for(Long id : ids)
			foodRepo.deleteById(id);
	}
	
}
