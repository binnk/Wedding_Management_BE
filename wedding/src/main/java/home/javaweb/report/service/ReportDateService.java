package home.javaweb.report.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.bill.entity.Bill;
import home.javaweb.report.entity.ReportDate;
import home.javaweb.report.entity.ReportMonth;
import home.javaweb.report.repository.ReportDateRepository;

@Service
public class ReportDateService implements IReportDateService	 {
	
	@Autowired
	private ReportDateRepository _repository;
	
	@Autowired
	private IReportMonthService reportMonthService;

	@Override
	public ReportDate save(Bill bill) {
		/*	Kiểm tra ngày của báo cáo đã tồn tại hay chưa??	*/
		LocalDate date = bill.getDateOfPayment();
		int month = date.getMonthValue();
		int year = date.getYear();
		
		if(!isExistDate(date)) {
			ReportDate report = new ReportDate(); 
			report.setDate(date);
			save(report);			
		}
		
		ReportDate existedReport = _repository.findByDate(date);
		existedReport.getBills().add(bill);
		existedReport.setFeastCount(_repository.selectCountFeast(existedReport.getId()));
		Long revenueDay = _repository.calculateRevenue(existedReport.getId());
		existedReport.setRevenue(revenueDay);		
		
		ReportMonth reportMonth = reportMonthService.checkExistReport(month, year);
		existedReport.setReportMonth(reportMonth);
		
		ReportDate result = _repository.save(existedReport);		
		// Update new info report month
		ReportMonth updatedReportMonth = reportMonthService.save(result);
		result.setRatio(revenueDay.floatValue() / reportMonth.getRevenue());
			
		return _repository.save(result);
	}
	
	public ReportDate save(ReportDate reportDate) {
		return _repository.save(reportDate);
	}
	
	private boolean isExistDate(LocalDate date) {
		ReportDate existReport = _repository.findByDate(date);
		if (existReport == null)
			return false;
		
		return true;
	}

	@Override
	public List<ReportDate> findAll() {
		LocalDate currentDate = LocalDate.now();
		int currentMonth = currentDate.getMonthValue();
		
		
		return _repository.findAll(currentMonth);
	}

	@Override
	public List<ReportDate> findByMonth(int month) {
		return _repository.findByMonth(month);
	}

	@Override
	public List<ReportDate> findAllBillByDate(LocalDate date) {
		return _repository.findAllBillByDate(date);
	}

	@Override
	public List<ReportDate> findByMonthAndYear(int month, int year) {
		return _repository.findByMonthAndYear(month, year);
	}



}
