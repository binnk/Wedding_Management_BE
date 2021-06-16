package home.javaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.converter.TableFoodConverter;
import home.javaweb.dto.TableFoodDTO;
import home.javaweb.embeddable.TableFoodId;
import home.javaweb.entity.FeastTable;
import home.javaweb.entity.TableFood;
import home.javaweb.repository.TableFoodRepository;
import home.javaweb.service.IFeastTableService;
import home.javaweb.service.ITableFoodService;

@Service
public class TableFoodService implements ITableFoodService {
	
	@Autowired
	private TableFoodRepository _repository;
	
	@Autowired
	private IFeastTableService _feastTableService;
	
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
		TableFood result = _repository.save(record);
		
		// Update FeastTable when save TableFood	
		Long feastTableId =dto.getFeastTableId();
		UpdateFeastTable(feastTableId);

		return result;
	}

	@Override
	public void deleteById(Long feastTableId, Long foodId) {
		TableFoodId id = new TableFoodId(feastTableId, foodId);
		_repository.deleteById(id);		
		UpdateFeastTable(feastTableId);
	}

	@Override
	public Long calcUnitTablePrice(Long feastTableId) {
		return _repository.getTotalPriceByFeastTable(feastTableId);
	}
	
	
	// Update FeastTable when save TableFood
	private void UpdateFeastTable(Long feastTableId) {
		Long unitTablePrice = calcUnitTablePrice(feastTableId);
		FeastTable feastTable = _feastTableService.findById(feastTableId);
		// Update Unit_Price of FeastTable
		feastTable.setUnitPriceTable(unitTablePrice);
		_feastTableService.save(feastTable);
		
	}

	@Override
	public void deleteByFeastTable(Long feastTableId) {
		_repository.deleteByFeastTable(feastTableId);
		
	}



}
