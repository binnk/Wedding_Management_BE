package home.javaweb.dto;

import java.util.ArrayList;
import java.util.List;

import home.javaweb.entity.FeastEntity;
import home.javaweb.entity.TableCategory;

public class FeastTableDTO {

	//Response
	private FeastEntity feast;	
	private List<FeastTableSupport> feastTables = new ArrayList<FeastTableSupport>();
	
	
	//Request
	private int numberTables;
	private int reverseTables;	
	private Long unitPriceTable;	
	private Long feastId;
	private Long tableCategoryId;
	private Long id;
	private String note;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FeastEntity getFeast() {
		return feast;
	}

	public void setFeast(FeastEntity feast) {
		this.feast = feast;
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

	public Long getFeastId() {
		return feastId;
	}

	public void setFeastId(Long feastId) {
		this.feastId = feastId;
	}

	public Long getTableCategoryId() {
		return tableCategoryId;
	}

	public void setTableCategoryId(Long tableCategoryId) {
		this.tableCategoryId = tableCategoryId;
	}

	public List<FeastTableSupport> getFeastTables() {
		return feastTables;
	}

	public void setFeastTables(List<FeastTableSupport> feastTables) {
		this.feastTables = feastTables;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
}
