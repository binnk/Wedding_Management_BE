package home.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import home.javaweb.entity.ShiftEntity;


public interface ShiftRepository extends JpaRepository<ShiftEntity, Long> {
		
	
}