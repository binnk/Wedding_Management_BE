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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "food")
public class Food {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="name")
	private String name;
	
	@Column(name = "img")
	private String img;
	
	@Column(name = "unit_price")
	private Long price;
	
	@Column(name = "more_info")
	private String moreInfo;
    private Boolean active;
	
	@ManyToOne
	@JoinColumn(name = "food_category_id")
	private FoodCategory foodCategory;
	
	@OneToMany(mappedBy = "food")
	@JsonIgnore
	private List<TableFood> feastTables = new ArrayList<TableFood>();
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}



	public FoodCategory getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(FoodCategory foodCategory) {
		this.foodCategory = foodCategory;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}

	public List<TableFood> getFeastTables() {
		return feastTables;
	}

	public void setFeastTables(List<TableFood> feastTables) {
		this.feastTables = feastTables;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}


	
	
	
}
