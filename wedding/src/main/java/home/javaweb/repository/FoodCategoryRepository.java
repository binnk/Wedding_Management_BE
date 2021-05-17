package home.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import home.javaweb.entity.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {

}
