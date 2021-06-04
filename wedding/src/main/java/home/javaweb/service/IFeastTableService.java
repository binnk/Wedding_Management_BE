package home.javaweb.service;

import java.util.List;

import home.javaweb.dto.FeastTableDTO;
import home.javaweb.entity.FeastTable;

public interface IFeastTableService {

	FeastTableDTO save(FeastTableDTO dto);
	FeastTable save(FeastTable entity);
	FeastTableDTO findByFeastId(Long feastId);
	void deleteById(Long[] ids);
	FeastTable findById(Long id);
	
}
