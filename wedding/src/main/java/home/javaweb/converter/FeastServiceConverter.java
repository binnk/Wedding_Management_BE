package home.javaweb.converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import home.javaweb.dto.FeastServiceDTO;
import home.javaweb.dto.ServiceCountDTO;
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
			ServiceCountDTO serviceCount = new ServiceCountDTO();

			serviceCount.setService(fs.getService());
			serviceCount.setCount(fs.getCount());
			result.getServices().add(serviceCount);
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

		return result;
	}



}
