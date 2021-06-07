package home.javaweb.bill.service;

import java.util.List;

import home.javaweb.bill.entity.Bill;

public interface IBillService {
	Long calcTotalServicePrice(Long feastId);
	Long calcTotalTablePrice(Long feastId);
	Bill getBillByFeast(Long feastId);
	void save(Bill entity);
	Bill save(Long feastId);
	List<Bill> findByStatus(int status);
	void deleteByFeast(Long feastId);
}
