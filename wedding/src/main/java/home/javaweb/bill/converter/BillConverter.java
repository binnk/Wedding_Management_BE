package home.javaweb.bill.converter;

import org.springframework.stereotype.Component;

import home.javaweb.bill.dto.BillDTO;
import home.javaweb.bill.entity.Bill;

@Component
public class BillConverter {
	
	public BillDTO toDTO(Bill entity) {
		BillDTO result = new BillDTO();
		
		result.setId(entity.getId());
		result.setFeast(entity.getFeast());
		result.setDateOfPayment(entity.getDateOfPayment());
		result.setFine(entity.getFine());
		result.setTotalBill(entity.getTotalBill());
		result.setTotalServicePrice(entity.getTotalServicePrice());
		result.setTotalTablePrice(entity.getTotalTablePrice());
		result.setUnpaidMoney(entity.getUnpaidMoney());

		return result;
	}
	
}
