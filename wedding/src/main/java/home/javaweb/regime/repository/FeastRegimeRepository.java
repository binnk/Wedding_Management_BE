package home.javaweb.regime.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import home.javaweb.regime.entity.FeastRegime;
import home.javaweb.regime.entity.FeastRegimeId;
import home.javaweb.regime.entity.Regime;

@Repository
public interface FeastRegimeRepository extends JpaRepository<FeastRegime, FeastRegimeId> {
	List<FeastRegime> findRegimeByFeastId(Long feastId);

	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM feast_regime fs WHERE fs.feast_id = ?1", nativeQuery = true)
	void deleteByFeast(Long feastId);
}
