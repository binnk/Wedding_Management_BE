package home.javaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import home.javaweb.entity.TableCategory;
import home.javaweb.repository.TableCategoryRepository;

@RestController
public class TableCategoryAPI {
	
	@Autowired
	private TableCategoryRepository _repo;
	
	@GetMapping("/table-category")
	public List<TableCategory> getAllCategories(){
		return _repo.findAll();
	}
	
}
