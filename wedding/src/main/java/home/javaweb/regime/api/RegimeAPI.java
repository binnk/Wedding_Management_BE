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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import home.javaweb.regime.dto.RegimeDTO;
import home.javaweb.regime.entity.Regime;
import home.javaweb.regime.service.RegimeService;

@CrossOrigin
@RestController
@RequestMapping("/api/regime")
public class RegimeAPI {

	@Autowired
	private RegimeService service;
	
	@GetMapping
	public ResponseEntity<Object>  getListFood() {
	List<Regime> regimes = service.findAll();
		
		if(regimes == null || regimes.isEmpty() ) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		}
		
		return new ResponseEntity<Object>(regimes, HttpStatus.OK);
	}
	
	@PostMapping
	public  ResponseEntity<Object> saveRegime(@RequestBody RegimeDTO dto) {
		Regime regime = service.save(dto);
		
		if(regime == null ) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		}	
		return new ResponseEntity<Object>(regime, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object>  delete(@PathVariable("id") Long id){
		if(id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);			
		}
		
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
