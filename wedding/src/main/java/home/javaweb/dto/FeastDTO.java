package home.javaweb.dto;

import java.time.LocalDate;

public class FeastDTO {
	
	private Long id;
	private String brideName;
	private String phone;
	private String weddingDate;
	private Long idShift;
	private String nameShift;
	private String  lobbyName;
	private Long lobbyId;
	private Float deposit;
	private String note;
	private String groomName;
	private String dateOfOrganization;
	public String getNameShift() {
		return nameShift;
	}
	public void setNameShift(String nameShift) {
		this.nameShift = nameShift;
	}
	public Long getLobbyId() {
		return lobbyId;
	}
	public void setLobbyId(Long lobbyId) {
		this.lobbyId = lobbyId;
	}
	public FeastDTO() {}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBrideName() {
		return brideName;
	}
	public void setBrideName(String brideName) {
		this.brideName = brideName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWeddingDate() {
		return weddingDate;
	}
	public void setWeddingDate(String weddingDate) {
		this.weddingDate = weddingDate;
	}
	public Long getIdShift() {
		return idShift;
	}
	public void setIdShift(Long idShift) {
		this.idShift = idShift;
	}
	public String getLobbyName() {
		return lobbyName;
	}
	public void setLobbyName(String lobbyName) {
		this.lobbyName = lobbyName;
	}

	public float getDeposit() {
		return deposit;
	}
	public void setDeposit(float deposit) {
		this.deposit = deposit;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getGroomName() {
		return groomName;
	}
	public void setGroomName(String groomName) {
		this.groomName = groomName;
	}
	
	public String getDateOfOrganization() {
		return dateOfOrganization;
	}
	public void setDateOfOrganization(String dateOfOrganization) {
		this.dateOfOrganization = dateOfOrganization;
	}
	public void setDeposit(Float deposit) {
		this.deposit = deposit;
	}
	public boolean IsAnyNullOrEmty() {
		
		if(this.brideName == null || "".equals(brideName)) return true;
		if(this.groomName == null || "".equals(groomName)) return true;
		if(this.deposit < 0 || this.deposit == null) return true;
		if(this.idShift == null ) return true;
		if(this.phone == null || "".equals(phone)) return true;
		if(this.weddingDate == null || "".equals(weddingDate)) return true;
		if(this.lobbyId == null || this.lobbyId < 1) return true;
		return false;
	}
	
	
}