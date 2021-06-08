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
	
	//Response
	private FeastTable feastTable;	
	List<FoodSupport> foods = new ArrayList<FoodSupport>();
	
	//Request	
	private Long feastTableId;	
	private Long foodId;	
	private int count; 
	private Long unitPrice;
	private Long totalPrice;	
	private String note;
	
	
	
	public List<FoodSupport> getFoods() {
		return foods;
	}
	public void setFoods(List<FoodSupport> foods) {
		this.foods = foods;
	}
	public FeastTable getFeastTable() {
		return feastTable;
	}
	public void setFeastTable(FeastTable feastTable) {
		this.feastTable = feastTable;
	}
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Long getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Long unitPrice) {
		this.unitPrice = unitPrice;
	}


	
	
}
