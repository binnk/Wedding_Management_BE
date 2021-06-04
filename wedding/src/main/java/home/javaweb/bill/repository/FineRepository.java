package home.javaweb.bill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import home.javaweb.bill.entity.Fine;

public interface FineRepository extends JpaRepository<Fine, Long> {
	
}
