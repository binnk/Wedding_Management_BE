package home.javaweb.bill.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.bill.entity.Fine;
import home.javaweb.bill.repository.FineRepository;
import home.javaweb.bill.service.IFineService;

@Service
public class FineService implements IFineService {
	@Autowired
	private FineRepository _repository;

	@Override
	public List<Fine> findAll() {
		return _repository.findAll();
	}

	@Override
	public Fine findById(Long id) {
		// TODO Auto-generated method stub
		return _repository.getOne(id);
	}

	@Override
	public Fine save(Fine fine) {
		return _repository.save(fine);
	}

	@Override
	public void deleteById(Long[] ids) {
		for(Long id : ids)
			_repository.deleteById(id);
			
	}
	
}
