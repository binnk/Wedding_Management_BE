package home.javaweb.report.service;

import java.util.List;

import home.javaweb.bill.entity.Bill;
import home.javaweb.report.entity.ReportDate;

public interface IReportDateService {
	ReportDate save(Bill bill);

	List<ReportDate> findAll();

	List<ReportDate> findByMonth(int month);
}
