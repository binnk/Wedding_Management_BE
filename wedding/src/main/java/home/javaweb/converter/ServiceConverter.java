package home.javaweb.converter;

import org.springframework.stereotype.Component;

import home.javaweb.dto.ServiceDTO;
import home.javaweb.entity.Service;

@Component
public class ServiceConverter {
	
	public ServiceDTO toDTO(Service entity) {
		ServiceDTO result = new ServiceDTO();
		
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setPrice(entity.getPrice());
		result.setImg(entity.getImg());

		return result;
	}
	
	public Service toEntity(ServiceDTO dto) {
		Service result = new Service();
		
		result.setId(dto.getId());
		result.setName(dto.getName());
		result.setPrice(dto.getPrice());
		result.setImg(dto.getImg());
		
		return result;
	}
}
