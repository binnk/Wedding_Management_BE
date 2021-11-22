package home.javaweb.regime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import home.javaweb.regime.entity.PromotionService;
import home.javaweb.report.entity.ReportDate;

public interface PromotionServiceRepository extends JpaRepository<PromotionService, Long>  {
	
}
