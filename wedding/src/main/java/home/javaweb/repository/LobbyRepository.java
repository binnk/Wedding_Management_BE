package home.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import home.javaweb.entity.LobbyEntity;


public interface LobbyRepository extends JpaRepository<LobbyEntity, Long> {

	List<LobbyEntity> findByName(String name);
}