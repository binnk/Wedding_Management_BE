package home.javaweb.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import home.javaweb.dto.FeastServiceDTO;
import home.javaweb.embeddable.FeastServiceId;
import home.javaweb.entity.FeastService;
import home.javaweb.entity.Service;

public interface FeastServiceRepository extends JpaRepository<FeastService, FeastServiceId> {
//	@Query(value = "Select s.id, s.image, s.name, s.unit_price "
//			+ "FROM feast_service fs INNER JOIN service s ON fs.service_id = s.id "
//			+ "WHERE fs.feast_id = :feastId", nativeQuery = true)
//	List<Map<Service, Long>> findByFeastId(@Param("feastId") Long feastId);
//
//	@Query(value = ""
//			+ "FROM feast_service fs INNER JOIN service s ON fs.service_id = s.id "
//			+ "WHERE fs.feast_id = :feastId", nativeQuery = true)
//	List<Map<Object, Long>> findByFeastIdServiceId(@Param("feastId") Long feastId);
//	
	
	List<FeastService> findByFeastId(Long feastId);
	
	FeastService findByFeastIdAndServiceId(Long feastId, Long serviceId);
	
//	@Query(value = "INSERT INTO feast_service(feast_id, service_id, count) "
//			+ "values (:feastId, :serviceId, :count)",
//			nativeQuery = true
//	)
//	boolean save (
//				@Param("feastId") Long feastId,
//				@Param("serviceId") Long serviceId,
//				@Param("count") int count );
	
}
