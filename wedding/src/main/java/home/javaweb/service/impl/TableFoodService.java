package home.javaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.converter.TableFoodConverter;
import home.javaweb.dto.TableFoodDTO;
import home.javaweb.embeddable.TableFoodId;
import home.javaweb.entity.TableFood;
import home.javaweb.repository.TableFoodRepository;
import home.javaweb.service.ITableFoodService;

@Service
public class TableFoodService implements ITableFoodService {
	
	@Autowired
	private TableFoodRepository _repository;
	
	@Autowired
	private TableFoodConverter _converter;

	@Override
	public TableFoodDTO findByFeastTableId(Long feastTableId) {
		TableFoodDTO result = new TableFoodDTO();
		
		List<TableFood> record = _repository.findByFeastTableId(feastTableId);
		result = _converter.toDTO(record);
		
		return result;
	}

	@Override
	public TableFood save(TableFoodDTO dto) {
		TableFood record = _converter.toEntity(dto);

		return _repository.save(record);
	}

	@Override
	public void deleteById(Long feastTableId, Long foodId) {
		TableFoodId id = new TableFoodId(feastTableId, foodId);
		_repository.deleteById(id);		
	}

}
