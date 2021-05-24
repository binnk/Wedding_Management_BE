package home.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import home.javaweb.entity.FeastEntity;

public interface FeastRepository extends JpaRepository<FeastEntity, Long> {

}