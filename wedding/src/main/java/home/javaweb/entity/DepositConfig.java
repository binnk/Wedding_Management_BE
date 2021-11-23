package home.javaweb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deposit_config")
public class DepositConfig {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int minPercentage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMinPercentage() {
		return minPercentage;
	}

	public void setMinPercentage(int minPercentage) {
		this.minPercentage = minPercentage;
	}
	
	
}
