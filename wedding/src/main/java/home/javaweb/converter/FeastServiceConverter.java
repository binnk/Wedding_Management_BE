package home.javaweb.converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import home.javaweb.dto.FeastServiceDTO;
import home.javaweb.dto.ServiceSupport;
import home.javaweb.dto.ServiceDTO;
import home.javaweb.entity.FeastService;
import home.javaweb.service.IServiceService;

@Component
public class FeastServiceConverter {

	@Autowired
	private IServiceService _service;

	@Autowired
	private ServiceConverter _serviceConverter;

	public FeastServiceDTO toDTO(List<FeastService> entities) {
		FeastServiceDTO result = new FeastServiceDTO();

		result.setFeast(entities.get(0).getFeast());

		for (FeastService fs : entities) {
			ServiceSupport serviceSupport = new ServiceSupport();

			serviceSupport.setService(fs.getService());
			serviceSupport.setCount(fs.getCount());
			serviceSupport.setTotalPrice(fs.getTotalPrice());
			serviceSupport.setNote(fs.getNote());
			result.getServices().add(serviceSupport);
		}

		return result;
	}

	public FeastService toEntity(FeastServiceDTO dto) {
		FeastService result = new FeastService();

		ServiceDTO service = _service.findById(dto.getFeastId());

		// set feast service
		// code here
		result.setService(_serviceConverter.toEntity(service));

		result.setCount(dto.getCount());
		result.setTotalPrice(dto.getTotalPrice());
		result.setNote(dto.getNote());

		return result;
	}



}
