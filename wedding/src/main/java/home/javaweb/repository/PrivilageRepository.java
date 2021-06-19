package home.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import home.javaweb.entity.Privilege;

public interface PrivilageRepository extends JpaRepository<Privilege, Long> {
    Privilege findByAuthority(String authority);
}
