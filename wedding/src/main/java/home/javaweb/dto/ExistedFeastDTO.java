package home.javaweb.dto;

public class ExistedFeastDTO {
	private Long shiftId;
	private Long lobbyId;
	private String dateOfOrganization;
	
	
	public String getDateOfOrganization() {
		return dateOfOrganization;
	}
	public void setDateOfOrganization(String dateOfOrganization) {
		this.dateOfOrganization = dateOfOrganization;
	}
	public Long getShiftId() {
		return shiftId;
	}
	public void setShiftId(Long shiftId) {
		this.shiftId = shiftId;
	}
	public Long getLobbyId() {
		return lobbyId;
	}
	public void setLobbyId(Long lobbyId) {
		this.lobbyId = lobbyId;
	}
	
	
}
