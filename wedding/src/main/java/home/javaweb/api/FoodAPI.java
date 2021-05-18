package home.javaweb.api;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import home.javaweb.dto.FoodDTO;
import home.javaweb.service.IFoodCategoryService;
import home.javaweb.service.IFoodService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class FoodAPI {

	@Autowired
	private IFoodService foodService;

	@Autowired
	private IFoodCategoryService categoryService;

	@GetMapping("/food")
	public List<FoodDTO> getListFood() {
		return foodService.findAll();
	}

	@PostMapping("/food")
	public FoodDTO createFood(
				@RequestBody FoodDTO dto
	) {

		dto.setCategory(categoryService.get(dto.getCategoryId()));
		return foodService.save(dto);
	}

	@PutMapping("/food")
	public FoodDTO updateFood(
				@RequestBody FoodDTO dto
			//	@PathVariable(value = "id") Long id
	) {


		dto.setCategory(categoryService.get(dto.getCategoryId()));
		return foodService.save(dto);
	}

	@DeleteMapping("/food")
	public ResponseEntity<?> deleteFoods (
			@RequestBody Long[] ids
	) {
		try {
			foodService.deleteById(ids);

			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


}
