package home.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import home.javaweb.embeddable.TableFoodId;
import home.javaweb.entity.TableFood;

public interface TableFoodRepository extends JpaRepository<TableFood, TableFoodId> {
	List<TableFood> findByFeastTableId(Long feastTableId);
	TableFood findByFeastTableIdAndFoodId(Long feastTableId, Long foodId);
	
	@Query(value = "SELECT SUM(tf.total_price) FROM table_food tf WHERE tf.feast_table_id =?1",nativeQuery = true )
	Long getTotalPriceByFeastTable(Long feastTableId);
}
