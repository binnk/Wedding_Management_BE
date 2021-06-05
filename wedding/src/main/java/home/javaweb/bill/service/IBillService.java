package home.javaweb.bill.service;

import home.javaweb.bill.dto.BillDTO;
import home.javaweb.bill.entity.Bill;

public interface IBillService {
	BillDTO findByFeastId(Long feastId);
	Long calcTotalServicePrice(Long feastId);
	Long calcTotalTablePrice(Long feastId);
	Bill getBillByFeast(Long feastId);
	void save(Bill entity);
}
