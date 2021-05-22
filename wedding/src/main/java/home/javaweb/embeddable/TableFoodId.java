package home.javaweb.embeddable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TableFoodId implements Serializable {

	@Column(name = "feast_table_id")
	private Long feastTableId;
	
	@Column(name = " food_id")
	private Long foodId;

	public Long getFeastTableId() {
		return feastTableId;
	}

	public void setFeastTableId(Long feastTableId) {
		this.feastTableId = feastTableId;
	}

	public Long getFoodId() {
		return foodId;
	}

	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}


 
		
	
}
