package home.javaweb.regime.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import home.javaweb.regime.dto.RegimeDTO;
import home.javaweb.regime.entity.Regime;
import home.javaweb.regime.repository.RegimeRepository;

@Service
public class RegimeServiceImpl implements RegimeService {
	
	@Autowired
	private RegimeRepository regimeRepository;
	

	@Override
	public List<Regime> findAll() {
		return regimeRepository.findByActive(true);
	}

	@Override
	public Regime findById(Long id) {
		return regimeRepository.findById(id).get();
	}

	@Override
	public Regime save(RegimeDTO dto) {
		Regime regime = new Regime();
		
		if(dto.getId() != null) {
			regime = regimeRepository.findById(dto.getId()).get();	
		}
		
		if(dto.getDescription() !=null) {
			regime.setDescription(dto.getDescription());		
		}
		
		if(dto.getPercentage() != 0) {
			regime.setPercentage(dto.getPercentage());	
		}
		
		if(dto.getRefund() != null) {
			regime.setRefund(dto.getRefund());	
		}
		
		if(dto.getSpecialDate() != null) {
			regime.setSpecialDate(dto.getSpecialDate());	
		}
		
		if(dto.getMinTotalBill() != null) {
			regime.setMinTotalBill(dto.getMinTotalBill());	
		}
		
		regime.setActive(true);
		
		return regimeRepository.save(regime);
	}

	@Override
	public void deleteById(Long id) {
		Regime regime = regimeRepository.findById(id).get();
		regime.setActive(false);
		
		regimeRepository.save(regime);
	}

}
