package home.javaweb.report.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import home.javaweb.report.dto.CountLobbyDTO;
import home.javaweb.report.dto.CountServiceDTO;
import home.javaweb.report.entity.ReportDate;

@Repository
public interface ReportDateRepository extends JpaRepository<ReportDate, Long> {


	ReportDate findByDate(LocalDate date);
	
	@Query(value = "SELECT COUNT(report_date_id) FROM report_date_detail WHERE report_date_id = ?1", nativeQuery = true)
	int selectCountFeast(Long reportId);
	
	@Query(value = "SELECT SUM(total_bill + total_fine) "
				+ "FROM report_date_detail rpd INNER JOIN bill b on rpd.bill_id = b.id "
				+ "WHERE rpd.report_date_id = ?1", nativeQuery = true)
	Long calculateRevenue(Long reportId);

	@Query(value = "SELECT rd "
				+ "FROM ReportDate rd "
				+ "WHERE MONTH(rd.date) < ?1")
	List<ReportDate> findAll(int currentMonth);

	@Query(value = "SELECT rd "
			+ "FROM ReportDate rd "
			+ "WHERE MONTH(rd.date) = ?1")
	List<ReportDate> findByMonth(int month);
	
	@Query(value = "SELECT rd "
			+ "FROM ReportDate rd "
			+ "WHERE MONTH(rd.date) = ?1 AND YEAR(rd.date) = ?2 ")
	List<ReportDate> findByMonthAndYear(int month, int year); 
	
	@Query(value = "SELECT rd "
			+ "FROM ReportDate rd "
			+ "WHERE MONTH(rd.date) = ?1 AND YEAR(rd.date) = ?2 ")
	List<ReportDate> findAllBillByDate(LocalDate date);

	@Query(value = "SELECT lob.name as lobbyName, SUM as count "
			+ "FROM bill b join feast f on b.feast_id = f.id join lobby lob on f.lobby_id = lob.id "
			+ "WHERE Year(b.date_of_payment) = ?2 AND MONTH(b.date_of_payment) = ?1 "
			+ "GROUP BY lob.name "
			+ "ORDER BY COUNT(f.lobby_id) DESC ", nativeQuery = true)
	List<CountLobbyDTO> selectCountLobby(int month, int year);

	@Query(value = "SELECT s.name as serviceName, SUM(fs.count) as count "
			+ "FROM bill b join feast f on b.feast_id = f.id join feast_service fs on f.id = fs.feast_id join service s on fs.service_id = s.id "
			+ "GROUP BY s.name "
			+ "ORDER BY SUM(fs.count) DESC ",nativeQuery = true)
	List<CountServiceDTO> selectCountService(int month, int year);


}