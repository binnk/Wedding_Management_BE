package home.javaweb.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import home.javaweb.embeddable.TableFoodId;
import home.javaweb.entity.FeastTable;
import home.javaweb.entity.Food;

public class TableFoodDTO {
	List<FoodSupport> foodSupports = new ArrayList<FoodSupport>();
	@EmbeddedId
	private TableFoodId id;
	
	
	@ManyToOne
	@MapsId("feastTableId")
	private FeastTable feastTable;
	
	@ManyToOne
	@MapsId("foodId")
	private Food food;
	
	@Column(name="total_price")
	private Long totalPrice;
	
	@Column(name="note")
	private String note;
	
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

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
