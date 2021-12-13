package home.javaweb.regime.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.embeddable.FeastServiceId;
import home.javaweb.entity.FeastEntity;
import home.javaweb.regime.dto.FeastRegimeDTO;
import home.javaweb.regime.entity.FeastRegime;
import home.javaweb.regime.entity.FeastRegimeId;
import home.javaweb.regime.entity.Regime;
import home.javaweb.regime.repository.FeastRegimeRepository;
import home.javaweb.regime.repository.RegimeRepository;
import home.javaweb.repository.FeastRepository;

@Service
public class FeastRegimeServiceImpl implements FeastRegimeService {
	
	@Autowired
	private FeastRegimeRepository feastRegimeRepo;
	
	@Autowired
	private FeastRepository feastRepository;
	
	@Autowired
	private RegimeService regimeService;

	@Override
	public void handleRegime(FeastRegimeDTO dto) {
		FeastRegime feastRegime = new FeastRegime();
		ArrayList<Long> oldRegimeId = dto.getOldRegimeId();
		
		
		for(Long newId : dto.getNewRegimeId()) {
			boolean flag = false;
			for(Long oldId : dto.getOldRegimeId()) {
				if(oldId == newId) {
					flag = true;
					oldRegimeId.remove(oldId);
					break;
				}
			}
			if (flag == false) {			
				FeastRegimeId feastRegimeId = new FeastRegimeId(dto.getFeastId(), newId);
				feastRegime.setId(feastRegimeId);
				feastRegimeRepo.save(feastRegime);
			} 
				
	
		}
		
		for(Long idDeleted : oldRegimeId) {
			removeRegime(dto.getFeastId(), idDeleted);
		}


	}


	public void removeRegime(Long feastId, Long regimeId) {		
		FeastRegimeId id = new FeastRegimeId(feastId, regimeId);
		feastRegimeRepo.deleteById(id);
	}

	@Override
	public List<FeastRegime> getRegimesByFeast(Long feastId) {
		List<FeastRegime> regimes = feastRegimeRepo.findRegimeByFeastId(feastId);
		return regimes;
	}


	@Override
	public void deleteByFeast(Long feastId) {
		feastRegimeRepo.deleteByFeast(feastId);
		
	}
	
	

}
