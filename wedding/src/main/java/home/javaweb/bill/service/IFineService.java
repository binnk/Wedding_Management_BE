package home.javaweb.bill.service;

import java.util.List;

import home.javaweb.bill.entity.Fine;

public interface IFineService {
	List<Fine> findAll();
	Fine findById(Long id);
	Fine save(Fine fine);
	void deleteById(Long[] ids);
}
