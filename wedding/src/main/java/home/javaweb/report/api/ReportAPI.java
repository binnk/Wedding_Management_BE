package home.javaweb.report.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import home.javaweb.report.entity.ReportDate;
import home.javaweb.report.service.IReportDateService;

@CrossOrigin
@RestController
@RequestMapping("/api/report")
public class ReportAPI {
	@Autowired
	private IReportDateService reportDate;
	
	@GetMapping("/month/{month}")
	public ResponseEntity<Object> getAllByMonth(@PathVariable("month") int month){
		List<ReportDate> reports = reportDate.findByMonth(month);
		if(reports.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Object>(reports, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<Object> findAll(){
		List<ReportDate> reports = reportDate.findAll();
		if(reports.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Object>(reports, HttpStatus.OK);
	}
	
//	@GetMapping
//	public ResponseEntity<Object> findAllByDate(){
//		List<ReportDate> reports = reportDate.findAll();
//		if(reports.isEmpty())
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		
//		return new ResponseEntity<Object>(reports, HttpStatus.OK);
//	}
	
}
