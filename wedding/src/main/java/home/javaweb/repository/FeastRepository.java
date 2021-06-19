package home.javaweb.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import home.javaweb.entity.FeastEntity;
import home.javaweb.entity.LobbyEntity;
import home.javaweb.entity.ShiftEntity;

public interface FeastRepository extends JpaRepository<FeastEntity, Long> {
//	@Query(" SELECT f from  FEAST f  where f.wedding_date = ?1 AND f.shift_id = ?2  AND f.lobby_id = ?3")
//         List<FeastEntity> checkExist(Date date, Long shift, Long lobby); 
//        	 
//         
}