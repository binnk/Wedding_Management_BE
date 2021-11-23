package home.javaweb.regime.service;

import java.util.List;

import org.springframework.stereotype.Service;

import home.javaweb.dto.FeastDTO;
import home.javaweb.entity.FeastEntity;
import home.javaweb.regime.entity.PromotionService;


public interface PromotionServiceService {
	 List<PromotionService> findAll();
	 PromotionService  save(PromotionService feast);
	 PromotionService findById(Long id);
	 void deleteById(Long id);
}
