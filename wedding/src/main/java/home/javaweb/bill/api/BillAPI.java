package home.javaweb.bill.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import home.javaweb.bill.entity.Bill;
import home.javaweb.bill.service.IBillService;

@CrossOrigin
@RestController
@RequestMapping("/api/bill")
public class BillAPI {
	
	@Autowired
	private IBillService service;
	
	@PreAuthorize("hasAuthority('READ_BILL')") 
	@GetMapping("/{feast-id}")
	public ResponseEntity<Object> getBillByFeast(@PathVariable("feast-id") Long feastId){
		Bill bill = service.getBillByFeast(feastId);
		if(bill == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Object>(bill, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('READ_BILL')") 
	@GetMapping("/status/{status}")
	public ResponseEntity<Object> findAllBillPaid(@PathVariable("status") int status){
		List<Bill> bills = service.findByStatus(status);

		if(bills == null || bills.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Object>(bills, HttpStatus.OK);		
	}
	
	@PreAuthorize("hasAuthority('UPDATE_BILL')") 
	@PutMapping("/{feast-id}")
	public ResponseEntity<Object> payBill(@PathVariable("feast-id") Long feastId){
		Bill bill = service.save(feastId);
		return new ResponseEntity<Object>(bill, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('UPDATE_BILL')") 
	@DeleteMapping("/feast/{bill-id}")
	public ResponseEntity<Object> deleteFeastInBill(@PathVariable("bill-id") Long billId){
		if(billId == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		service.deleteFeastInBillById(billId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
