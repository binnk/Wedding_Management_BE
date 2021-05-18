package home.javaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import home.javaweb.dto.FoodDTO;
import home.javaweb.service.IFoodService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class FoodAPI {
	
	@Autowired
	private IFoodService foodService;
	
	@GetMapping("/food")
	public List<FoodDTO> getListFood() {
		return foodService.findAll();
	}
}
