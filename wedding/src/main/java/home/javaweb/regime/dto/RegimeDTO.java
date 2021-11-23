package home.javaweb.regime.dto;

public class RegimeDTO {
	private Long id;
	
	private int percentage;
	
	private String description;

	private Long promotionServiceId;

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

	public Long getPromotionServiceId() {
		return promotionServiceId;
	}

	public void setPromotionServiceId(Long promotionServiceId) {
		this.promotionServiceId = promotionServiceId;
	}
	
	
	
}
