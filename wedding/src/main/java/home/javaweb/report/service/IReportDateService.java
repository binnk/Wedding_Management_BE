package home.javaweb.report.service;

import home.javaweb.bill.entity.Bill;
import home.javaweb.report.entity.ReportDate;

public interface IReportDateService {
	ReportDate save(Bill bill);
}
