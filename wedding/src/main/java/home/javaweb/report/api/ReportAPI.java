package home.javaweb.report.api;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import home.javaweb.report.dto.CountFoodDTO;
import home.javaweb.report.dto.CountLobbyDTO;
import home.javaweb.report.dto.CountServiceDTO;
import home.javaweb.report.entity.ReportDate;
import home.javaweb.report.service.IReportDateService;

@CrossOrigin
@RestController
@RequestMapping("/api/report")
public class ReportAPI {
	@Autowired
	private IReportDateService reportDate;
	
	@PreAuthorize("hasAuthority('READ_REPORT')") 
	@GetMapping("/month/{month}")
	public ResponseEntity<Object> getAllByMonth(@PathVariable("month") int month){
		List<ReportDate> reports = reportDate.findByMonth(month);
		if(reports.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Object>(reports, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('READ_REPORT')") 
	@GetMapping
	public ResponseEntity<Object> findAll(){
		List<ReportDate> reports = reportDate.findAll();
		if(reports.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Object>(reports, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('READ_REPORT')") 
	@GetMapping("/date")
	public ResponseEntity<Object> findAllByDate(@RequestParam String date){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    	LocalDate localDate = LocalDate.parse(date, dtf);
		List<ReportDate> reports = reportDate.findAllBillByDate(localDate);
		if(reports.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Object>(reports, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('READ_REPORT')") 
	@GetMapping("/month/{month}/year/{year}")
	public ResponseEntity<Object> findByMonthAndYear(
						@PathVariable("month") int month,
						@PathVariable("year") int year
			){
		List<ReportDate> reports = reportDate.findByMonthAndYear(month, year);
		if(reports.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Object>(reports, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('READ_REPORT')") 
	@GetMapping("lobby/month/{month}/year/{year}")
	public ResponseEntity<Object> selectCountLobby(
						@PathVariable("month") int month,
						@PathVariable("year") int year
			){
		List<CountLobbyDTO> reports = reportDate.selectCountLobby(month, year);
		if(reports.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Object>(reports, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('READ_REPORT')") 
	@GetMapping("service/month/{month}/year/{year}")
	public ResponseEntity<Object> selectCountService(
						@PathVariable("month") int month,
						@PathVariable("year") int year
			){
		List<CountServiceDTO> reports = reportDate.selectCountService(month, year);
		if(reports.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Object>(reports, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('READ_REPORT')") 
	@GetMapping("food/month/{month}/year/{year}")
	public ResponseEntity<Object> selectCountFood(
						@PathVariable("month") int month,
						@PathVariable("year") int year
			){
		List<CountFoodDTO> reports = reportDate.selectCountFood(month, year);
		if(reports.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Object>(reports, HttpStatus.OK);
	}
	
}
