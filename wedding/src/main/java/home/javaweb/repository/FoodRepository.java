package home.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import home.javaweb.entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

}
