package home.javaweb.dto;
public class LobbyDTO {
	private Long id;
	private String name;
	private String LobbyCategory;
	private Long idLobbyCategory;	
	private  int minTableCategory;
	private String image;
	private int maxTable;
	
	private Long minUnitPriceTable;
	public Long getMinUnitPriceTable() {
		return minUnitPriceTable;
	}
	public void setMinUnitPriceTable(Long minUnitPriceTable) {
		this.minUnitPriceTable = minUnitPriceTable;
	}
	public Long getIdLobbyCategory() {
		return idLobbyCategory;
	}
	public void setIdLobbyCategory(Long idLobbyCategory) {
		this.idLobbyCategory = idLobbyCategory;
	}
	public LobbyDTO idLobbyCategory(Long id) {
		this.idLobbyCategory = id;
		return this;
	}
	public LobbyDTO name(String name) {
		this.name = name;
		return this;
	}
	public LobbyDTO id(Long id) {
		this.id = id;
		return this;
	}
	public LobbyDTO LobbyCategory(String Lobbycategory) {
		this.LobbyCategory = Lobbycategory;
		return this;
	}
	public LobbyDTO image(String image) {
		this.image = image;
		return this;
	}
	public LobbyDTO maxTable(int maxTable) {
		this.maxTable = maxTable;
		return this;
	}
	public LobbyDTO minTableCategory(int min) {
		this.minTableCategory = min;
		return this;
	}
	public LobbyDTO minUnitPriceTable(Long minUnitPriceTable) {
		this.minUnitPriceTable = minUnitPriceTable;
		return this;
	}
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
	public String getLobbycategory() {
		return LobbyCategory;
	}
	public void setLobbycategory(String id_lobycategory) {
		this.LobbyCategory = id_lobycategory;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getMaxtable() {
		return maxTable;
	}
	public void setMaxtable(int maxtable) {
		this.maxTable = maxtable;
	}
	public int getMinTableCategory() {
		return minTableCategory;
	}
	public void setMinTableCategory(int minTableCategory) {
		this.minTableCategory = minTableCategory;
	}
	
}