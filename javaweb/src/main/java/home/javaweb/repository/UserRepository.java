package home.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import home.javaweb.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByUsername(String username);	
}
