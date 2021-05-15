package home.javaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import home.javaweb.dto.FeastDTO;
import home.javaweb.service.IFeastService;

@RestController
public class FeastAPI {
  @Autowired
  private IFeastService  feastser;
  //some thing change
  @GetMapping(path = "/feast")
	public List<FeastDTO> weddingPage() {
		return feastser.findAll();		
	}
	@PostMapping("/feast")
	public ResponseEntity<FeastDTO> createFeast (@RequestBody FeastDTO feast ) throws Exception {
		FeastDTO result = null;
		result = feastser.save(feast);
		if(result != null) {
			return  new ResponseEntity<FeastDTO>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@PutMapping("/feast")
	public ResponseEntity<FeastDTO> updateFeast (@RequestBody FeastDTO feast ) throws Exception {
		FeastDTO result = null;
		result = feastser.update(feast);
		if(result != null) {
			return  new ResponseEntity<FeastDTO>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@DeleteMapping(path="feast/{id}")
	public void deleteFeast (@PathVariable("id") Long id ) {
		 feastser.delete(id);
	}
	
}