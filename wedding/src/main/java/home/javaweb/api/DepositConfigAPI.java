package home.javaweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import home.javaweb.entity.DepositConfig;
import home.javaweb.repository.DepositConfigRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/deposit")
public class DepositConfigAPI {
	
	@Autowired
	private DepositConfigRepository repository;
	
	@GetMapping
	public ResponseEntity<Object> getDepositConfig() {
		DepositConfig deposit = repository.findById(1L).get();	
		return new ResponseEntity<>(deposit,HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Object> changeDepositConfig(@RequestBody DepositConfig deposit) {
		System.out.println("Min percentagte: " + deposit.getMinPercentage());
		DepositConfig newDeposit = new DepositConfig();
		newDeposit.setId(1L);
		newDeposit.setMinPercentage(deposit.getMinPercentage());				
		repository.save(newDeposit);	
		return new ResponseEntity<>(newDeposit,HttpStatus.OK);
	}
	
	
}
