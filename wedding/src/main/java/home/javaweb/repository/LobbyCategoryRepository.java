package home.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import home.javaweb.entity.LobbyCategoryEntity;
import home.javaweb.entity.LobbyEntity;

public interface LobbyCategoryRepository extends JpaRepository<LobbyCategoryEntity, Long> {
	List<LobbyCategoryEntity> findByName(String name);
}
