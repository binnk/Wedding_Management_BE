package home.javaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.entity.FoodCategory;
import home.javaweb.repository.FoodCategoryRepository;
import home.javaweb.service.IFoodCategoryService;


@Service
public class FoodCategoryService implements IFoodCategoryService {

	@Autowired
	private FoodCategoryRepository categoryRepo;
	
	@Override
	public List<FoodCategory> findAll() {
		return categoryRepo.findAll();
	}

	@Override
	public FoodCategory save(FoodCategory newCategory) {
		return categoryRepo.save(newCategory);
	}

	@Override
	public FoodCategory get(Long id) {
		return categoryRepo.findById(id).get();
	}

	@Override
	public void deleteById(Long[] ids) {
		for(Long id : ids)
			categoryRepo.deleteById(id);
	}

}
