package home.javaweb.report.service;

import java.time.LocalDate;
import java.util.List;

import home.javaweb.bill.entity.Bill;
import home.javaweb.report.dto.CountLobbyDTO;
import home.javaweb.report.dto.CountServiceDTO;
import home.javaweb.report.entity.ReportDate;

public interface IReportDateService {
	ReportDate save(Bill bill);

	List<ReportDate> findAll();

	List<ReportDate> findByMonth(int month);

	List<ReportDate> findAllBillByDate(LocalDate date);

	List<ReportDate> findByMonthAndYear(int month, int year);

	List<CountLobbyDTO> selectCountLobby(int month, int year);

	List<CountServiceDTO> selectCountService(int month, int year);
}
