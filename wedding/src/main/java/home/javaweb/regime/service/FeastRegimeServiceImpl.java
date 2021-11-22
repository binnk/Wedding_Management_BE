package home.javaweb.regime.service;

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
	public void addRegime(FeastRegimeDTO dto) {
		FeastRegime feastRegime = new FeastRegime();
		
		FeastEntity feast = feastRepository.findById(dto.getFeastId()).get();
		Regime regime = regimeService.findById(dto.getRegimeId());
		
		feastRegime.setRegime(regime);
		feastRegime.setFeast(feast);
	}

	@Override
	public void removeRegime(FeastRegimeDTO dto) {		
		FeastRegimeId id = new FeastRegimeId(dto.getFeastId(), dto.getRegimeId());	
		feastRegimeRepo.deleteById(id);
	}

	@Override
	public List<FeastRegime> getRegimesByFeast(Long feastId) {
		List<FeastRegime> regimes = feastRegimeRepo.findRegimeByFeastId(feastId);
		return regimes;
	}
	
	

}
