package home.javaweb.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import home.javaweb.report.entity.ReportMonth;

public interface ReportMonthRepository extends JpaRepository<ReportMonth, Long> {

	ReportMonth findByMonthAndYear(int month, int year);

	@Query(value = "SELECT SUM(rd.revenue) "
				+  "FROM report_date rd "
				+  "WHERE report_month_id = ?1 ", nativeQuery = true)
	Long calculateRevenue(Long id);

}
