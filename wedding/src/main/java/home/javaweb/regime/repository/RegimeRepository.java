package home.javaweb.regime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import home.javaweb.regime.entity.PromotionService;
import home.javaweb.regime.entity.Regime;

public interface RegimeRepository  extends JpaRepository<Regime, Long>{

}
