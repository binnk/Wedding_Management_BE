package home.javaweb.regime.service;

import java.util.List;

import home.javaweb.regime.dto.FeastRegimeDTO;
import home.javaweb.regime.entity.FeastRegime;
import home.javaweb.regime.entity.Regime;

public interface FeastRegimeService {
	void handleRegime(FeastRegimeDTO dto);
	List<FeastRegime> getRegimesByFeast(Long feastId);
	void deleteByFeast(Long feastId);
}
