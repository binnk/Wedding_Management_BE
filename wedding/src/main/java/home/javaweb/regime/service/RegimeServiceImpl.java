package home.javaweb.regime.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.regime.dto.RegimeDTO;
import home.javaweb.regime.entity.PromotionService;
import home.javaweb.regime.entity.Regime;
import home.javaweb.regime.repository.PromotionServiceRepository;
import home.javaweb.regime.repository.RegimeRepository;

@Service
public class RegimeServiceImpl implements RegimeService {
	
	@Autowired
	private RegimeRepository regimeRepository;
	
	@Autowired
	private PromotionServiceRepository promotionRepository;

	@Override
	public List<Regime> findAll() {
		return regimeRepository.findAll();
	}

	@Override
	public Regime findById(Long id) {
		return regimeRepository.findById(id).get();
	}

	@Override
	public Regime save(RegimeDTO dto) {
		Regime regime = new Regime();
		
		if(dto.getId() != null) {
			regime.setId(dto.getId());		
		}
		
		regime.setPercentage(dto.getPercentage());
		regime.setDescription(dto.getDescription());
		
		PromotionService promotion = promotionRepository.findById(dto.getPromotionServiceId()).get();
		regime.setPromotionService(promotion);
		
		return regimeRepository.save(regime);
	}

	@Override
	public void deleteById(Long id) {
		regimeRepository.deleteById(id);		
	}

}
