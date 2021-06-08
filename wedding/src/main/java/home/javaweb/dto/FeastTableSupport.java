package home.javaweb.dto;

import home.javaweb.entity.TableCategory;

public class FeastTableSupport {
	private Long id;
	private TableCategory tableCategory; 
	private int numberTables;
	private int reverseTables;	
	private Long unitPriceTable;
	private Long totalPrice;
	private String note;
	
	
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TableCategory getTableCategory() {
		return tableCategory;
	}
	public void setTableCategory(TableCategory tableCategory) {
		this.tableCategory = tableCategory;
	}
	public int getNumberTables() {
		return numberTables;
	}
	public void setNumberTables(int numberTables) {
		this.numberTables = numberTables;
	}
	public int getReverseTables() {
		return reverseTables;
	}
	public void setReverseTables(int reverseTables) {
		this.reverseTables = reverseTables;
	}
	public Long getUnitPriceTable() {
		return unitPriceTable;
	}
	public void setUnitPriceTable(Long unitPriceTable) {
		this.unitPriceTable = unitPriceTable;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
