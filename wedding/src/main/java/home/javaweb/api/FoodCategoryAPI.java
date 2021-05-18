package home.javaweb.api;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import home.javaweb.entity.FoodCategory;
import home.javaweb.service.IFoodCategoryService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class FoodCategoryAPI {
	
	@Autowired
	private IFoodCategoryService categoryService;
	
	@GetMapping("/food-category")
	public List<FoodCategory> getCategories(){
		return categoryService.findAll();
	}
	
	@PostMapping("/food-category")
	public FoodCategory createCategory(@RequestBody FoodCategory category){
		return categoryService.save(category);
	}
	
	@PutMapping("/food-category/{id}")
	public ResponseEntity<?> createCategory(@RequestBody FoodCategory category, @PathVariable("id") Long idUpdated){
		try {
			FoodCategory existCategory = categoryService.get(idUpdated);
			categoryService.save(category);
			
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (NoSuchElementException e) { 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/food-category")
	public void delete(@RequestBody Long[] ids){
		categoryService.deleteById(ids);
	}
}
