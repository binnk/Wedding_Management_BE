package home.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import home.javaweb.embeddable.TableFoodId;
import home.javaweb.entity.TableFood;

public interface TableFoodRepository extends JpaRepository<TableFood, TableFoodId> {
	List<TableFood> findByFeastTableId(Long feastTableId);
	TableFood findByFeastTableIdAndFoodId(Long feastTableId, Long foodId);
}
