package home.javaweb.regime.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import home.javaweb.regime.entity.Regime;

public interface RegimeRepository  extends JpaRepository<Regime, Long>{
	List<Regime> findByActive(Boolean active);
}
