package home.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import home.javaweb.converter.ServiceConverter;
import home.javaweb.dto.ServiceDTO;
import home.javaweb.entity.Service;
import home.javaweb.repository.ServiceRepository;
import home.javaweb.service.IServiceService;


import org.springframework.beans.factory.annotation.Autowired;


@org.springframework.stereotype.Service
public class ServiceService implements IServiceService {

	@Autowired
	private ServiceRepository _repo;
	
	@Autowired
	private ServiceConverter _converter;
	
	@Override
	public List<ServiceDTO> findAll() {
		List<ServiceDTO> result = new ArrayList<ServiceDTO>();
		
		List<Service> services = _repo.findAll();
		
		for(Service service : services) {
			if(service.getActive())
			result.add(_converter.toDTO(service));
		}
		return result;
	}

	@Override
	public ServiceDTO save(ServiceDTO dto) {
		Service service = _converter.toEntity(dto);
		
		_repo.save(service);
		
		return _converter.toDTO(service);
	}

	@Override
	public void deleteById(Long[] ids) {
		Service service = null;
		for(Long id : ids) {
			service = _repo.getOne(id);
			if(service != null) service.setActive(false);
			_repo.save(service);
		}
			
	}

	@Override
	public ServiceDTO findById(Long id) {
		return _converter.toDTO(_repo.findById(id).get());
	}

}
