package home.javaweb.service;

import java.util.List;

import home.javaweb.entity.TableCategory;

public interface ITableCategoryService {
	List<TableCategory> findAll();
	TableCategory save(TableCategory category);
	TableCategory findById(Long id);
	void deleteById(Long[] ids);
}
