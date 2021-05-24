package home.javaweb.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import home.javaweb.embeddable.TableFoodId;

@Entity
@Table(name = "table_food")
public class TableFood {
	
	@EmbeddedId
	private TableFoodId id;
	
	@ManyToOne
	@MapsId("feastTableId")
	private FeastTable feastTable;
	
	@ManyToOne
	@MapsId("foodId")
	private Food food;
	
	@Column(name = "count")
	private int count;

	public TableFoodId getId() {
		return id;
	}

	public void setId(TableFoodId id) {
		this.id = id;
	}

	public FeastTable getFeastTable() {
		return feastTable;
	}

	public void setFeastTable(FeastTable feastTable) {
		this.feastTable = feastTable;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
