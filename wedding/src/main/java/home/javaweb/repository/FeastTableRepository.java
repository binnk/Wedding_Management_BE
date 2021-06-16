package home.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import home.javaweb.entity.FeastTable;

public interface FeastTableRepository extends JpaRepository<FeastTable, Long>{
	List<FeastTable> findByFeastId(Long feastId);

	@Query(value = "SELECT SUM(ft.total_price) "
				+ "FROM feast_table ft"
				+ " WHERE ft.feast_id = ?1", 
			nativeQuery = true)
	Long getTotalPriceByFeast(Long feastId);
}
