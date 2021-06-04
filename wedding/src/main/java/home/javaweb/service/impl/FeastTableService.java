package home.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.converter.FeastTableConverter;
import home.javaweb.dto.FeastTableDTO;
import home.javaweb.entity.FeastTable;
import home.javaweb.repository.FeastTableRepository;
import home.javaweb.service.IFeastTableService;


@Service
public class FeastTableService implements IFeastTableService {
	
	@Autowired
	private FeastTableRepository _repository;
	
	@Autowired
	private FeastTableConverter _converter;



	@Override
	public FeastTableDTO save(FeastTableDTO dto) {
		
		FeastTable record = _converter.toEntity(dto);
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
		return _repository.save(entity);
	}

}
