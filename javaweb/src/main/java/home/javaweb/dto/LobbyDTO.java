package home.javaweb.dto;
public class LobbyDTO {
	
	private String name;
	private String id_lobycategory;
	private String image;
	private int maxtable;
	private int min_unitpricetable;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId_lobycategory() {
		return id_lobycategory;
	}
	public void setId_lobycategory(String id_lobycategory) {
		this.id_lobycategory = id_lobycategory;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getMaxtable() {
		return maxtable;
	}
	public void setMaxtable(int maxtable) {
		this.maxtable = maxtable;
	}
	public int getMin_unitpricetable() {
		return min_unitpricetable;
	}
	public void setMin_unitpricetable(int min_unitpricetable) {
		this.min_unitpricetable = min_unitpricetable;
	}
}
