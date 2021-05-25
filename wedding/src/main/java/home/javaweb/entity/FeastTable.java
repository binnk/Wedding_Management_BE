package home.javaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "feast_table")
public class FeastTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "feastTable")
	private List<TableFood> foods = new ArrayList<TableFood>(); 
	
	@ManyToOne
	@JoinColumn(name = "table_category_id")
	private TableCategory tableCategory;
	
	@ManyToOne
	@JoinColumn(name = "feast_id")
	private FeastEntity feast;
	
	@Column(name= "number_tables")
	private int numberTables;
	
	@Column(name = "reserve_tables")
	private int reverseTables;
	
	@Column(name = "unit_price_table")
	private Long unitPriceTable;
	
	@Column(name = "note")
	private String note;
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public List<TableFood> getFoods() {
		return foods;
	}

	public void setFoods(List<TableFood> foods) {
		this.foods = foods;
	}

	public TableCategory getTableCategory() {
		return tableCategory;
	}

	public void setTableCategory(TableCategory tableCategory) {
		this.tableCategory = tableCategory;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
	
	
}
