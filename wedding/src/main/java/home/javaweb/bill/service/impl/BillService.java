package home.javaweb.bill.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.bill.dto.BillDTO;
import home.javaweb.bill.entity.Bill;
import home.javaweb.bill.repository.BillRepository;
import home.javaweb.bill.service.IBillService;
import home.javaweb.service.IFeastServiceService;
import home.javaweb.service.ITableFoodService;

@Service
public class BillService implements IBillService {
	
	@Autowired
	private BillRepository _repository;
	@Autowired
	private IFeastServiceService _feastService;
	@Autowired
	private ITableFoodService _tableService;
	
	@Override
	public BillDTO findByFeastId(Long feastId) {
		BillDTO result = new BillDTO();
		

		
		return null;
	}
	
	
	public Long calcTotalServicePrice(Long feastId) {
		Long result = _feastService.getTotalPriceByFeast(feastId);
		return result;			
	}
	
	public Long calcTotalTablePrice(Long feastId) {
		Long result = _feastService.getTotalPriceByFeast(feastId);
		return result;			
	}
}
