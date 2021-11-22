package home.javaweb.bill.service.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.bill.entity.Bill;
import home.javaweb.bill.entity.Fine;
import home.javaweb.bill.repository.BillRepository;
import home.javaweb.bill.service.IBillService;
import home.javaweb.bill.service.IFineService;
import home.javaweb.entity.FeastEntity;
import home.javaweb.report.service.IReportDateService;
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
	@Autowired
	private IReportDateService _reportService;
	


	@Override
	public void save(Bill entity) {
		 _repository.save(entity);		
	}
	
	

	@Override
	public Bill getBillByFeast(Long feastId) {
		Bill entity = _repository.findByFeastId(feastId);
		
		Long totalServicePrice = calcTotalServicePrice(feastId);
		if(totalServicePrice == null)
			totalServicePrice = 0L;
		Long totalTablePrice = calcTotalTablePrice(feastId);
		if(totalTablePrice == null)
			totalTablePrice = 0L;
		Integer numberTable = calcTotalTables(feastId);
		
	
		
		//Calculate fine by day
		Fine fine = _fineService.findById(entity.getFine().getId());
		LocalDate currentDate = LocalDate.now();
		FeastEntity feast = _feastService.findById(feastId);
		LocalDate dateOfPayment = feast.getDateOfOrganization();
		
		
		Long regimeRefund = feast.getRegimeRefund();
		Long weddingRefund = feast.getWeddingRefund();
		
		Long totalBill = totalServicePrice + totalTablePrice - regimeRefund - weddingRefund;
		
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
		entity.setNumberOfTables(numberTable);

		return entity;
		
	}

	@Override
	public Bill save(Long feastId) {
		Bill bill = getBillByFeast(feastId);
		// Bill has been payed
		bill.setStatus(1);
		bill.setUnpaidMoney(0L);
		Bill result = _repository.save(bill);
		
		_reportService.save(bill);
			
		return result;
		
	}
	
	public Integer calcTotalTables(Long feastId) {
		return _fTableService.getTotalTable(feastId);
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
	public List<Bill> findByStatus(int status) {
		return _repository.findByStatus(status);
	}

	@Override
	public void deleteByFeast(Long feastId) {
		_repository.deleteByFeastId(feastId);
		
	}

	@Override
	public void deleteFeastInBillById(Long billId) {
		Bill bill = _repository.findById(billId).get();
		Long feastId = bill.getFeast().getId();
		bill.setFeast(null);
		
		_feastService.delete(feastId);
		
		_repository.save(bill);
		
	}



	@Override
	public Bill findByFeastId(Long feastId) {
		return _repository.findByFeastId(feastId);
	}

}
