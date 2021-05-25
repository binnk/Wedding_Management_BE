package home.javaweb.converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import home.javaweb.dto.FeastServiceDTO;
import home.javaweb.dto.FeastTableDTO;
import home.javaweb.dto.FoodDTO;
import home.javaweb.dto.FoodSupport;
import home.javaweb.dto.ServiceDTO;
import home.javaweb.dto.ServiceSupport;
import home.javaweb.dto.TableFoodDTO;
import home.javaweb.embeddable.TableFoodId;
import home.javaweb.entity.FeastService;
import home.javaweb.entity.FeastTable;
import home.javaweb.entity.TableFood;
import home.javaweb.service.IFeastTableService;
import home.javaweb.service.IFoodService;
import home.javaweb.service.IServiceService;


@Component
public class TableFoodConverter {
	
	@Autowired
	private IFoodService _foodService;

	@Autowired
	private FoodConverter _foodConverter;
	
	@Autowired 
	private IFeastTableService _feastTableService;
	
	@Autowired
	private FeastTableConverter _feastTableConverter;

	public TableFoodDTO toDTO(List<TableFood> entities) {
		TableFoodDTO result = new TableFoodDTO();

		result.setFeastTable(entities.get(0).getFeastTable());

		for (TableFood entity : entities) {
			FoodSupport foodSupport = new FoodSupport();
			
			foodSupport.setFood(entity.getFood());
			foodSupport.setCount(entity.getCount());
			foodSupport.setNote(entity.getNote());
			foodSupport.setTotalPrice(entity.getTotalPrice());
			
			result.getFoods().add(foodSupport);
		}

		return result;
	}

	public TableFood toEntity(TableFoodDTO dto) {
		TableFood result = new TableFood();

		FoodDTO food = _foodService.findById(dto.getFoodId());
		result.setFood(_foodConverter.toEntity(food));
		
		FeastTable feastTable = _feastTableService.findById(dto.getFeastTableId());
		result.setFeastTable(feastTable);
		
		result.setCount(dto.getCount());
		result.setTotalPrice(dto.getTotalPrice());
		result.setNote(dto.getNote());
		
		Long feastTableId = dto.getFeastTableId();
		Long foodId = dto.getFoodId();
		
		TableFoodId id = new TableFoodId();
		id.setFeastTableId(feastTableId);
		id.setFoodId(foodId);	
		result.setId(id);

		return result;
	}
}
