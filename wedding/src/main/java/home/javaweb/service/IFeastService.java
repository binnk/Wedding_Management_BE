package home.javaweb.service;

import java.util.List;

import home.javaweb.dto.FeastDTO;
import home.javaweb.entity.FeastEntity;


public interface IFeastService {
     List<FeastDTO> findAll();
     FeastDTO  save(FeastDTO feast);
     FeastDTO update(FeastDTO feast);
     FeastEntity findById(Long id);
     void delete(Long id);
	void deleteById(Long id);
}