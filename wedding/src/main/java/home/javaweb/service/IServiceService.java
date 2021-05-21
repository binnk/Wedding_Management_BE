package home.javaweb.service;

import java.util.List;

import home.javaweb.dto.ServiceDTO;

public interface IServiceService {
	List<ServiceDTO> findAll();
	ServiceDTO save(ServiceDTO dto);
	void deleteById(Long[] ids);
}
