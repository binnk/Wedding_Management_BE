package home.javaweb.service;

import home.javaweb.dto.TableFoodDTO;
import home.javaweb.entity.TableFood;

public interface ITableFoodService  {
	TableFoodDTO findByFeastTableId(Long feastTableId);
	TableFood save(TableFoodDTO dto);
	void deleteById(Long feastTableId, Long foodId);
	Long getTotalPrice(Long feastTableId);
}
