package home.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import home.javaweb.entity.FeastTable;

public interface FeastTableRepository extends JpaRepository<FeastTable, Long>{
	List<FeastTable> findByFeastId(Long feastId);
}
