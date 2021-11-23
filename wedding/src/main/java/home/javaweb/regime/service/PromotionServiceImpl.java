package home.javaweb.regime.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.regime.entity.PromotionService;
import home.javaweb.regime.repository.PromotionServiceRepository;

@Service
public class PromotionServiceImpl implements PromotionServiceService {
	
	@Autowired
	private PromotionServiceRepository repository;

	@Override
	public List<PromotionService> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public PromotionService save(PromotionService promotion) {
		return repository.save(promotion);
	}

	@Override
	public PromotionService findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);	
	}



}
