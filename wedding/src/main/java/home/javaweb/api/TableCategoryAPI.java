package home.javaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import home.javaweb.entity.TableCategory;
import home.javaweb.repository.TableCategoryRepository;
import home.javaweb.service.ITableCategoryService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TableCategoryAPI {
	
	@Autowired
	private ITableCategoryService _service;
	
	@GetMapping("/table-category")
	public List<TableCategory> getAllCategories(){
		return _service.findAll();
	}
	
	@PostMapping("/table-category")
	public TableCategory createCategory(@RequestBody TableCategory category) {
		return _service.save(category);
	}
	
	@PutMapping("/table-category")
	public TableCategory updateCategory(@RequestBody TableCategory category) {
		return _service.save(category);
	}
	
	@DeleteMapping("/table-category")
	public void deleteCategories(@RequestBody Long[] ids) {
		 _service.deleteById(ids);
	}
}
