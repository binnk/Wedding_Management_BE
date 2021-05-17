package home.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import home.javaweb.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
