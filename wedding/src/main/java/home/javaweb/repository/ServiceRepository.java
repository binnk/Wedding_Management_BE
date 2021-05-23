package home.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import home.javaweb.entity.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
