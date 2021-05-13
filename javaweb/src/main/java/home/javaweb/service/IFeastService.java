package home.javaweb.service;

import java.util.List;

import home.javaweb.dto.FeastDTO;


public interface IFeastService {
     List<FeastDTO> findAll(int limmit, int offset);
     FeastDTO  save(FeastDTO feast);
     FeastDTO update(FeastDTO feast);
     void delete(Long id);
}
