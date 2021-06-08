package home.javaweb.bill.api;

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

import home.javaweb.bill.entity.Bill;
import home.javaweb.bill.entity.Fine;
import home.javaweb.bill.service.IBillService;
import home.javaweb.bill.service.IFineService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class FineAPI {

	@Autowired
	private IFineService _service;
	

	@GetMapping("/fines")
	public ResponseEntity<Object> findAll(){
		List<Fine> fines = _service.findAll();
		if(fines == null || fines.isEmpty())
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Object>(fines, HttpStatus.OK);
	}
	

	@GetMapping("/fines/{id}")
	public ResponseEntity<Object> findById(@PathVariable(value ="id") Long id){
		Fine fine = _service.findById(id);
		if(fine == null)
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Object>(fine, HttpStatus.OK);
	}
	
	@PostMapping("/fines")
	public ResponseEntity<Object> save(@RequestBody Fine fine){
		Fine savedFine = _service.save(fine);
		return new ResponseEntity<Object>(savedFine, HttpStatus.OK);
	}
	
	@PutMapping("/fines")
	public ResponseEntity<Object> update(@RequestBody Fine fine){
		Fine savedFine = _service.save(fine);
		return new ResponseEntity<Object>(savedFine, HttpStatus.OK);
	}
	
	@DeleteMapping("/fines")
	public void delete(@RequestBody Long[] ids){
		_service.deleteById(ids);
	}
}

