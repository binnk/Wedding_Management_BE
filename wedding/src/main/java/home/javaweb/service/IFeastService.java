package home.javaweb.service;

import java.util.List;

import home.javaweb.dto.FeastDTO;
import home.javaweb.entity.FeastEntity;
import home.javaweb.regime.dto.FeastRegimeDTO;
import home.javaweb.regime.entity.Regime;


public interface IFeastService {
     List<FeastDTO> findAll();
     FeastDTO  save(FeastDTO feast);
     FeastDTO update(FeastDTO feast);
     FeastEntity findById(Long id);
     void delete(Long id);
	void deleteById(Long id);
	Boolean checkExist(FeastDTO feast);

}