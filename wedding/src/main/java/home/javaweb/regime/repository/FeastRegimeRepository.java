package home.javaweb.regime.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import home.javaweb.regime.entity.FeastRegime;
import home.javaweb.regime.entity.FeastRegimeId;
import home.javaweb.regime.entity.Regime;

@Repository
public interface FeastRegimeRepository extends JpaRepository<FeastRegime, FeastRegimeId> {
	List<FeastRegime> findRegimeByFeastId(Long feastId);
}
