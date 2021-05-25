package home.javaweb.dto;

import home.javaweb.entity.FoodCategory;

public class FoodDTO {
	
	private Long 			id;	
	private String 			name;
	private String		 	img;
	private Long 			price;
	private FoodCategory 	category;
	private Long 			categoryId;
	private String 			moreInfo;
	private String 			note;

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

	public FoodCategory getCategory() {
		return category;
	}

	public void setCategory(FoodCategory foodCategory) {
		this.category = foodCategory;
	}
	
	
	public String getMoreInfo() {
		return moreInfo;
	}


	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}
	
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}
