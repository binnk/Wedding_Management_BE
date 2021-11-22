package home.javaweb.regime.api;

import java.util.List;

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

import home.javaweb.dto.FoodDTO;
import home.javaweb.regime.entity.PromotionService;
import home.javaweb.regime.service.PromotionServiceService;

@CrossOrigin
@RestController
@RequestMapping("/api/promotion-service")
public class PromotionServiceAPI {
	
	@Autowired
	private PromotionServiceService service;
	
	@GetMapping
	public ResponseEntity<Object> findAll() {
		List<PromotionService> promotions = service.findAll();
		
		if(promotions == null || promotions.isEmpty() ) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		}
		
		return new ResponseEntity<Object>(promotions, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> createPromotionService(@RequestBody PromotionService entity) {
		PromotionService promotion = service.save(entity);
		
		if(promotion == null ) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		}
		
		return new ResponseEntity<Object>(promotion, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public  ResponseEntity<Object> deleteById(@PathVariable("id") Long id){
		
		if(id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);			
		}
		
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
