package home.javaweb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import home.javaweb.common.ERole;
import home.javaweb.entity.RoleEntity;

@Repository
public interface  RoleRepository extends JpaRepository<RoleEntity, Long> {
     Optional<RoleEntity> findByName(ERole name);
}
