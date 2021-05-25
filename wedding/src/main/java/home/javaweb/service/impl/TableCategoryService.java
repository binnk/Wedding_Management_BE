package home.javaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.entity.TableCategory;
import home.javaweb.repository.TableCategoryRepository;
import home.javaweb.service.ITableCategoryService;

@Service
public class TableCategoryService implements ITableCategoryService {
	
	@Autowired
	private TableCategoryRepository _repository;

	@Override
	public List<TableCategory> findAll() {
		return _repository.findAll();
	}

	@Override
	public TableCategory save(TableCategory category) {
		return _repository.save(category);
	}

	@Override
	public void deleteById(Long[] ids) {
		for(Long id : ids)
			_repository.deleteById(id);
		
	}

	@Override
	public TableCategory findById(Long id) {
		return _repository.findById(id).get();
	}

	

}
