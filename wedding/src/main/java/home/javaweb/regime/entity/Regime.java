package home.javaweb.regime.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import home.javaweb.entity.FeastEntity;
import home.javaweb.entity.FeastService;
import home.javaweb.entity.FoodCategory;

@Entity
@Table(name = "regime")
public class Regime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int percentage;
	
	private String description;

	@ManyToOne
	@JoinColumn(name = "promotion_service_id")
	private PromotionService promotionService;
	
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

	public PromotionService getPromotionService() {
		return promotionService;
	}

	public void setPromotionService(PromotionService promotionService) {
		this.promotionService = promotionService;
	}
	
	
	
	
	
}
