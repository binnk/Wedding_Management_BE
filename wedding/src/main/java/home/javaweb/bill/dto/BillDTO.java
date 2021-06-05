package home.javaweb.bill.dto;

import java.time.LocalDate;
import java.util.Date;

import home.javaweb.bill.entity.Fine;
import home.javaweb.entity.FeastEntity;

public class BillDTO {
	private Long		 id;
	private FeastEntity	 feast;
	private LocalDate 		 dateOfPayment;
	private Long		 totalTablePrice;
	private Long		 totalServicePrice;
	private Fine		 fine;	
	private Long		 totalBill;
	private Long		 unpaidMoney;
	private boolean		 status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public FeastEntity getFeast() {
		return feast;
	}
	public void setFeast(FeastEntity feast) {
		this.feast = feast;
	}
	public LocalDate getDateOfPayment() {
		return dateOfPayment;
	}
	public void setDateOfPayment(LocalDate dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}
	public Long getTotalTablePrice() {
		return totalTablePrice;
	}
	public void setTotalTablePrice(Long totalTablePrice) {
		this.totalTablePrice = totalTablePrice;
	}
	public Long getTotalServicePrice() {
		return totalServicePrice;
	}
	public void setTotalServicePrice(Long totalServicePrice) {
		this.totalServicePrice = totalServicePrice;
	}
	public Fine getFine() {
		return fine;
	}
	public void setFine(Fine fine) {
		this.fine = fine;
	}
	public Long getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(Long totalBill) {
		this.totalBill = totalBill;
	}
	public Long getUnpaidMoney() {
		return unpaidMoney;
	}
	public void setUnpaidMoney(Long unpaidMoney) {
		this.unpaidMoney = unpaidMoney;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	
	
}
