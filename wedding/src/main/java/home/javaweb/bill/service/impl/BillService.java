package home.javaweb.bill.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.bill.dto.BillDTO;
import home.javaweb.bill.entity.Bill;
import home.javaweb.bill.entity.Fine;
import home.javaweb.bill.repository.BillRepository;
import home.javaweb.bill.service.IBillService;
import home.javaweb.bill.service.IFineService;
import home.javaweb.entity.FeastEntity;
import home.javaweb.service.IFeastService;
import home.javaweb.service.IFeastServiceService;
import home.javaweb.service.IFeastTableService;

@Service
public class BillService implements IBillService {
	
	@Autowired
	private BillRepository _repository;
	@Autowired
	private IFeastServiceService _feastSService;
	@Autowired
	private IFeastTableService _fTableService;
	@Autowired
	private IFineService _fineService;
	@Autowired 
	private IFeastService _feastService;
	
	@Override
	public BillDTO findByFeastId(Long feastId) {
		BillDTO result = new BillDTO();
		

		
		return null;
	}
	
	
	public Long calcTotalServicePrice(Long feastId) {
		Long result = _feastSService.getTotalPriceByFeast(feastId);
		return result;			
	}
	
	public Long calcTotalTablePrice(Long feastId) {
		Long result = _fTableService.getTotalPrice(feastId);
		return result;			
	}


	@Override
	public void save(Bill entity) {
		Long feastId = entity.getFeast().getId();
		
		Long totalServicePrice = calcTotalServicePrice(feastId);
		Long totalTablePrice = calcTotalTablePrice(feastId);
		
		Long totalBill = totalServicePrice + totalTablePrice;
		
		//Calculate fine by day
		Fine fine = _fineService.findById(entity.getFine().getId());
		LocalDate currentDate = LocalDate.now();
		FeastEntity feast = _feastService.findById(feastId);
		LocalDate dateOfPayment = feast.getDateOfOrganization();
		
		//Calculate currentDate - dateOfPayment
		Long overdueDay = ChronoUnit.DAYS.between(dateOfPayment, currentDate);
		if (overdueDay < 0)
			overdueDay = 0L;
		
		Long totalFine = totalBill * fine.getPercent() * overdueDay / 100;
		
	}
	
//	public void test() {
//		Long feastId = 1L;
//		
//		Long totalServicePrice = calcTotalServicePrice(feastId);
//		Long totalTablePrice = calcTotalTablePrice(feastId);
//		
//		Long totalBill = totalServicePrice + totalTablePrice;
//		
//		//Calculate fine by day
//		Fine fine = _fineService.findById(1L);
//		LocalDate currentDate = LocalDate.now();
//		FeastEntity feast = _feastService.findById(feastId);
//		LocalDate dateOfPayment = feast.getDateOfOrganization();
//		
//		//Calculate currentDate - dateOfPayment
//		Long overdueDay = ChronoUnit.DAYS.between(currentDate, currentDate);
//		if (overdueDay < 0)
//			overdueDay = 0L;
//		Long totalFine = totalBill * fine.getPercent() * overdueDay / 100;
//		System.out.println(totalFine);
//	}
	

	@Override
	public Bill getBillByFeast(Long feastId) {
		Bill entity = _repository.findByFeastId(feastId);
		
		Long totalServicePrice = calcTotalServicePrice(feastId);
		Long totalTablePrice = calcTotalTablePrice(feastId);
		
		Long totalBill = totalServicePrice + totalTablePrice;
		
		//Calculate fine by day
		Fine fine = _fineService.findById(entity.getFine().getId());
		LocalDate currentDate = LocalDate.now();
		FeastEntity feast = _feastService.findById(feastId);
		LocalDate dateOfPayment = feast.getDateOfOrganization();
		
		//Calculate currentDate - dateOfPayment
		Long overdueDay = ChronoUnit.DAYS.between(dateOfPayment, currentDate);
		if (overdueDay < 0)
			overdueDay = 0L;
		Long totalFine = totalBill * fine.getPercent() * overdueDay / 100;
		
		Long deposit = (long)feast.getDeposit();
		Long unpaidMoney = totalBill + totalFine - deposit;
		
		entity.setDateOfPayment(currentDate);
		entity.setTotalServicePrice(totalServicePrice);
		entity.setTotalTablePrice(totalTablePrice);
		entity.setTotalBill(totalBill);
		entity.setTotalFine(totalFine);
		entity.setUnpaidMoney(unpaidMoney);

		return entity;
		
	}
	
}
