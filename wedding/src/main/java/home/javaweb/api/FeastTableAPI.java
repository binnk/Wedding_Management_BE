package home.javaweb.api;

import java.util.List;

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

import home.javaweb.dto.FeastTableDTO;
import home.javaweb.service.IFeastTableService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class FeastTableAPI {
	
	@Autowired
	private IFeastTableService _service;
	
	
	@GetMapping("/feast/{feastid}/table")
	public FeastTableDTO getTablesByFeastid(@PathVariable(value = "feastid") Long feastId){
		return _service.findByFeastId(feastId);
	}
	
	@PostMapping("/feast-table")
	public FeastTableDTO createFeastTable(@RequestBody FeastTableDTO dto) {
		return _service.save(dto);
	}
	
	@PutMapping("/feast-table")
	public FeastTableDTO updateFeastTable(@RequestBody FeastTableDTO dto) {
		return _service.save(dto);
	}
	
	@DeleteMapping("/feast-table")
	public void deleteFeastTables(@RequestBody Long[] ids) {
		 _service.deleteById(ids);
	}
	

}
