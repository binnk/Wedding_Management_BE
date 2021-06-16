package home.javaweb.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import home.javaweb.embeddable.TableFoodId;
import home.javaweb.entity.TableFood;

public interface TableFoodRepository extends JpaRepository<TableFood, TableFoodId> {
	List<TableFood> findByFeastTableId(Long feastTableId);
	TableFood findByFeastTableIdAndFoodId(Long feastTableId, Long foodId);
	
	@Query(value = "SELECT SUM(tf.total_price) FROM table_food tf WHERE tf.feast_table_id =?1",nativeQuery = true )
	Long getTotalPriceByFeastTable(Long feastTableId);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM table_food WHERE feast_table_id = ?1", nativeQuery = true)
	void deleteByFeastTable(Long feastTableId);
}
