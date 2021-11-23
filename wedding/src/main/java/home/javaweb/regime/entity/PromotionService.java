package home.javaweb.regime.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import home.javaweb.entity.Food;

@Entity
@Table(name = "promotion_service")
public class PromotionService {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	private Long refund;

	public Long getId() {
		return id;
	}
	
	@OneToMany(mappedBy = "promotionService")
	@JsonIgnore
	private List<Regime> regimes = new ArrayList<Regime>();

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getRefund() {
		return refund;
	}

	public void setRefund(Long refund) {
		this.refund = refund;
	}

	public List<Regime> getRegimes() {
		return regimes;
	}

	public void setRegimes(List<Regime> regimes) {
		this.regimes = regimes;
	}


	
	
	
	
}
