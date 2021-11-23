package home.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import home.javaweb.entity.DepositConfig;


public interface DepositConfigRepository extends JpaRepository<DepositConfig, Long> {
	
}
