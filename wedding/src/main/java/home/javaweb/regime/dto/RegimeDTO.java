package home.javaweb.regime.dto;

public class RegimeDTO {
	private Long id;
	
	private int percentage;
	
	private String description;
	
	private String specialDate;

	private Long refund;
	
	private String minTotalBill;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSpecialDate() {
		return specialDate;
	}

	public void setSpecialDate(String specialDate) {
		this.specialDate = specialDate;
	}

	public Long getRefund() {
		return refund;
	}

	public void setRefund(Long refund) {
		this.refund = refund;
	}

	public String getMinTotalBill() {
		return minTotalBill;
	}

	public void setMinTotalBill(String minTotalBill) {
		this.minTotalBill = minTotalBill;
	}


	
	
}
