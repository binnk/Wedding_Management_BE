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

import home.javaweb.regime.dto.FeastRegimeDTO;
import home.javaweb.regime.entity.FeastRegime;
import home.javaweb.regime.entity.Regime;
import home.javaweb.regime.service.FeastRegimeService;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class FeastRegimeAPI {
	
	@Autowired
	private FeastRegimeService service;

	
    @GetMapping("/feast/{feast-id}/regime")
 	public ResponseEntity<Object> getRegimeByFeast(@PathVariable("feast-id") Long feastId) {
 		System.out.println(feastId);
    	
    	if(feastId == null) {
 			return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 			
 		}
 		
 		List<FeastRegime> regimes = service.getRegimesByFeast(feastId);
 		if(regimes.isEmpty()) {
 			return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
 		}
 		
 		return new ResponseEntity<>(regimes, HttpStatus.OK); 
 	}
    
    @PostMapping("/feast/regime")
  	public ResponseEntity<Object> handleRegime(@RequestBody FeastRegimeDTO dto) {
     	
    	service.handleRegime(dto);
 		return new ResponseEntity<>(HttpStatus.OK); 
  	
  	}
    


}
