package home.javaweb.bill.service;

import home.javaweb.bill.dto.BillDTO;

public interface IBillService {
	BillDTO findByFeastId(Long feastId);
	Long calcTotalServicePrice(Long feastId);
	Long calcTotalTablePrice(Long feastId);
}
