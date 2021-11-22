package home.javaweb.regime.service;

import java.util.List;

import home.javaweb.regime.dto.RegimeDTO;
import home.javaweb.regime.entity.Regime;

public interface RegimeService {
	
	List<Regime> findAll();
	Regime findById(Long id);
	Regime save(RegimeDTO dto);
	void deleteById(Long id);
	

}
