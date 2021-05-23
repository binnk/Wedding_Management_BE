package home.javaweb.service;

import java.util.List;

import home.javaweb.dto.ServiceDTO;
import home.javaweb.entity.Service;

public interface IServiceService {
	List<ServiceDTO> findAll();
	ServiceDTO save(ServiceDTO dto);
	ServiceDTO findById(Long id);
	void deleteById(Long[] ids);
}
