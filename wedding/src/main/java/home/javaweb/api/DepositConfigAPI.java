package home.javaweb.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<Object> changeDepositConfig(DepositConfig deposit) {
		deposit.setId(1L);
		DepositConfig newDeposit = repository.save(deposit)	;
		return new ResponseEntity<>(newDeposit,HttpStatus.OK);
	}
	
	
}
