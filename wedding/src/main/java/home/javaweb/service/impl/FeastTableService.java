package home.javaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.converter.FeastTableConverter;
import home.javaweb.dto.FeastTableDTO;
import home.javaweb.entity.FeastEntity;
import home.javaweb.entity.FeastTable;
import home.javaweb.repository.FeastTableRepository;
import home.javaweb.service.IFeastService;
import home.javaweb.service.IFeastTableService;
import home.javaweb.service.ITableFoodService;


@Service
public class FeastTableService implements IFeastTableService {
	
	@Autowired
	private FeastTableRepository _repository;
	@Autowired
	private IFeastService _feastService;
	
	@Autowired
	private FeastTableConverter _converter;
	@Autowired
	private ITableFoodService tableFoodService;


	@Override
	public FeastTableDTO save(FeastTableDTO dto) {
		
		FeastTable record = _converter.toEntity(dto);
		
		FeastEntity feastEntity = _feastService.findById(dto.getFeastId());
		Long minPriceTable = feastEntity.getId_lobby().getMinUnitPriceTable();

		if(minPriceTable > record.getUnitPriceTable())
			record.setUnitPriceTable(minPriceTable);
		
		int count = record.getNumberTables() + record.getReverseTables();
		record.setTotalPrice(count * minPriceTable);
		
		_repository.save(record);
		FeastTableDTO result = findByFeastId(dto.getFeastId());
		
		return result;
	}

	@Override
	public FeastTableDTO findByFeastId(Long feastId) {
		FeastTableDTO result = new FeastTableDTO();
		
		List<FeastTable> list = _repository.findByFeastId(feastId);
		result = _converter.toDTO(list);
		
		return result;
		
	}

	@Override
	public void deleteById(Long[] ids) {
		for(Long id : ids)
			_repository.deleteById(id);		
	}

	@Override
	public FeastTable findById(Long id) {
		return _repository.findById(id).get();
	}

	@Override
	public FeastTable save(FeastTable entity) {
		FeastEntity feastEntity = _feastService.findById(entity.getFeast().getId());
		Long minPriceTable = feastEntity.getId_lobby().getMinUnitPriceTable();

		if(minPriceTable > entity.getUnitPriceTable())
			entity.setUnitPriceTable(minPriceTable);
		
		int count = entity.getNumberTables() + entity.getReverseTables();
		entity.setTotalPrice(count * minPriceTable);
		
		return _repository.save(entity);
	}

	@Override
	public Long getTotalPrice(Long feastId) {
		return _repository.getTotalPriceByFeast(feastId);
	}

	@Override
	public void deleteByFeast(Long id) {
		
		List<FeastTable> tables = _repository.findByFeastId(id);
		if(tables.isEmpty() == false) {
			Long  feastTableId = tables.get(0).getId();
			tableFoodService.deleteByFeastTable(feastTableId);
		}
		
		_repository.deleteByFeast(id);
		
	}

}
