package home.javaweb.service;

import home.javaweb.dto.FeastTableDTO;
import home.javaweb.entity.FeastTable;

public interface IFeastTableService {

	FeastTableDTO save(FeastTableDTO dto);
	FeastTable save(FeastTable entity);
	FeastTableDTO findByFeastId(Long feastId);
	void deleteById(Long[] ids);
	FeastTable findById(Long id);
	
	// Total price of FEAST
	Long getTotalPrice(Long feastId);
	void deleteByFeast(Long id);
	
}
