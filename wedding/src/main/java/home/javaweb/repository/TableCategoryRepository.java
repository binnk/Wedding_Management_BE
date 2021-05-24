package home.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import home.javaweb.entity.TableCategory;

public interface TableCategoryRepository extends JpaRepository<TableCategory, Long> {

}
