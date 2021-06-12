package home.javaweb.report.service;

import home.javaweb.report.entity.ReportDate;
import home.javaweb.report.entity.ReportMonth;

public interface IReportMonthService {
	ReportMonth save(ReportDate reportDate);
	ReportMonth checkExistReport(int month, int year);
}
