package home.javaweb.service;

import java.util.List;

import home.javaweb.dto.FeastTableDTO;

public interface IFeastTableService {

	FeastTableDTO save(FeastTableDTO dto);
	FeastTableDTO findByFeastId(Long feastId);
	void deleteById(Long[] ids);
	
	
}
