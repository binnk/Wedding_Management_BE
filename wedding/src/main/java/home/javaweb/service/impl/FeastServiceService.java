package home.javaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.converter.FeastServiceConverter;
import home.javaweb.dto.FeastServiceDTO;
import home.javaweb.entity.FeastService;
import home.javaweb.repository.FeastServiceRepository;
import home.javaweb.service.IFeastServiceService;

@Service
public class FeastServiceService implements IFeastServiceService{
	
	@Autowired
	private FeastServiceRepository _repository;
	
	@Autowired
	private FeastServiceConverter _converter;
	
	@Override
	public FeastServiceDTO findByFeastId(Long feastId) {
		
		FeastServiceDTO result= new FeastServiceDTO();
		
		List<FeastService> list = _repository.findByFeastId(feastId);	
		result = _converter.toDTO(list);
		
		return result;
	}

	@Override
	public FeastService save(FeastServiceDTO dto) {
		FeastServiceDTO result = new FeastServiceDTO();
		
		FeastService record = new FeastService();
		
		Long feastId = dto.getFeastId();
		Long serviceId = dto.getServiceId();
		int	count = dto.getCount();
		
		
		boolean checkInsert = _repository.save(feastId, serviceId, count);
		FeastService fService = findByFeastIdAndServiceId(feastId, serviceId);
		
		record.setCount(dto.getCount());
		record.setFeast(fService.getFeast());
		record.setService(fService.getService());
		
		
		return record;
	}

	@Override
	public FeastService findByFeastIdAndServiceId(Long feastId, Long serviceId) {
		return _repository.findByFeastIdAndServiceId(feastId, serviceId);
	}

}
