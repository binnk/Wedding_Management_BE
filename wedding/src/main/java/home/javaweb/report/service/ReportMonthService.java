package home.javaweb.report.service;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.report.entity.ReportDate;
import home.javaweb.report.entity.ReportMonth;
import home.javaweb.report.repository.ReportMonthRepository;

@Service
public class ReportMonthService implements IReportMonthService{
	
	@Autowired
	private ReportMonthRepository _repository;

	@Override
	public ReportMonth save(ReportDate reportDate) {
		LocalDate date = reportDate.getDate();
		int month = date.getMonthValue();
		int year = date.getYear();
		
		checkExistReport(month, year);
		
		ReportMonth existedReport = _repository.findByMonthAndYear(month, year);
		Long revenue = _repository.calculateRevenue(existedReport.getId());
		existedReport.setRevenue(revenue);
		
		return _repository.save(existedReport);
	}

	private boolean isExistMonthAndYear(int month, int year) {
		ReportMonth report = _repository.findByMonthAndYear(month, year);
		if(report.getId() == null)
			return false;
		
		return true;
	}

	@Override
	public ReportMonth checkExistReport(int month, int year) {
		if(!isExistMonthAndYear(month, year)) {
			ReportMonth report = new ReportMonth();
			report.setMonth(month);
			report.setYear(year);
			return _repository.save(report);
		}
		return _repository.findByMonthAndYear(month, year);
	}
	
	
	
	
}
