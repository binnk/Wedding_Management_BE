package home.javaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.converter.FeastServiceConverter;
import home.javaweb.dto.FeastServiceDTO;
import home.javaweb.embeddable.FeastServiceId;
import home.javaweb.entity.FeastEntity;
import home.javaweb.entity.FeastService;
import home.javaweb.repository.FeastServiceRepository;
import home.javaweb.repository.ServiceRepository;
import home.javaweb.service.IFeastService;
import home.javaweb.service.IFeastServiceService;
import home.javaweb.service.IServiceService;

@Service
public class FeastServiceService implements IFeastServiceService{
	
	@Autowired
	private FeastServiceRepository _repository;
	
	@Autowired
	private FeastServiceConverter _converter;
	
	@Autowired
	private IFeastService _feastService;
	
	@Autowired
	private ServiceRepository _serviceRepo;
	
	@Override
	public FeastServiceDTO findByFeastId(Long feastId) {
		
		FeastServiceDTO result= new FeastServiceDTO();
		
		List<FeastService> list = _repository.findByFeastId(feastId);	
		result = _converter.toDTO(list);
		
		return result;
	}

	@Override
	public FeastService save(FeastServiceDTO dto) {
		FeastService result = new FeastService();
		
		FeastService record = new FeastService();
		
		Long feastId = dto.getFeastId();
		Long serviceId = dto.getServiceId();
		int	count = dto.getCount();
		String note = dto.getNote();
		Long totalPrice = dto.getTotalPrice();
	
		
		FeastEntity feast = _feastService.findById(feastId);
		home.javaweb.entity.Service service = _serviceRepo.findById(serviceId).get();
		
		FeastServiceId fsId = new FeastServiceId();
		fsId.setFeastId(feastId);
		fsId.setServiceId(serviceId);
		
		record.setId(fsId);		
		record.setFeast(feast);
		record.setService(service);
		
		record.setCount(dto.getCount());
		record.setTotalPrice(dto.getTotalPrice());
		record.setNote(dto.getNote());
		
		//_repository.save(record);
		
		return 	_repository.save(record);
	}

	@Override
	public FeastService findByFeastIdAndServiceId(Long feastId, Long serviceId) {
		return _repository.findByFeastIdAndServiceId(feastId, serviceId);
	}

	@Override
	public void deleteById(Long feastId, Long serviceId) {
		
		FeastServiceId id = new FeastServiceId(feastId, serviceId);	
		_repository.deleteById(id);
		
	}

}
