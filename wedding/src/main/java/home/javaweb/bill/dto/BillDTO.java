package home.javaweb.bill.dto;

import java.util.Date;

import home.javaweb.bill.entity.Fine;
import home.javaweb.entity.FeastEntity;

public class BillDTO {
	private Long		 id;
	private FeastEntity	 feast;
	private Date 		 dateOfPayment;
	private Long		 totalTablePrice;
	private Long		 totalServicePrice;
	private Fine		 fine;	
	private Long		 totalBill;
	private Long		 unpaidMoney;
	
	
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
	public Date getDateOfPayment() {
		return dateOfPayment;
	}
	public void setDateOfPayment(Date dateOfPayment) {
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
	
	
}
