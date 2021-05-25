package home.javaweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import home.javaweb.dto.TableFoodDTO;
import home.javaweb.entity.TableFood;
import home.javaweb.service.ITableFoodService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TableFoodAPI {
	
	@Autowired
	private ITableFoodService _service;
	
	@GetMapping("/feast-table/{feasttableid}/food")
	public TableFoodDTO getByFeastTableId(@PathVariable(value = "feasttableid") Long feastTableId) {
		return _service.findByFeastTableId(feastTableId);
	}
	
	@PostMapping("/feast-table/food")
	public TableFood addFood(@RequestBody TableFoodDTO dto) {
			return _service.save(dto);
	}
	
	@PutMapping("/feast-table/food")
	public TableFood updateFood(@RequestBody TableFoodDTO dto) {
			return _service.save(dto);
	}
	
	@DeleteMapping("/feast-table/{feasttableid}/food/{foodid}")
	public void deleteTableFood(
			@PathVariable(value = "feasttableid") Long feastTableId,
			@PathVariable(value = "foodid") Long foodId
	) {
		 _service.deleteById(feastTableId, foodId);
	}
}
