package home.javaweb.dto;
import java.util.Date;

public class FeastDTO {
	
	
	private String bridename;
	private String phone;
	private Date wedding_date;
	private Long id_shift;
	private  LobbyDTO lobby;
	private Long number_of_tables;
	private Long estimated_number_of_tables;
	private float unitprice_table;
	private float deposit;
	private String note;
	
	private String groomname;
	public String getGroomname() {
		return groomname;
	}
	public void setGroomname(String groomname) {
		this.groomname = groomname;
	}
	public String getBridename() {
		return bridename;
	}
	public void setBridename(String bridename) {
		this.bridename = bridename;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getWedding_date() {
		return wedding_date;
	}
	public void setWedding_date(Date wedding_date) {
		this.wedding_date = wedding_date;
	}
	public Long getId_shift() {
		return id_shift;
	}
	public void setId_shift(Long id_shift) {
		this.id_shift = id_shift;
	}
	public LobbyDTO getLobby() {
		return lobby;
	}
	public void setLobby(LobbyDTO lobby) {
		this.lobby = lobby;
	}
	public Long getNumber_of_tables() {
		return number_of_tables;
	}
	public void setNumber_of_tables(Long number_of_tables) {
		this.number_of_tables = number_of_tables;
	}
	public Long getEstimated_number_of_tables() {
		return estimated_number_of_tables;
	}
	public void setEstimated_number_of_tables(Long estimated_number_of_tables) {
		this.estimated_number_of_tables = estimated_number_of_tables;
	}
	public float getUnitprice_table() {
		return unitprice_table;
	}
	public void setUnitprice_table(float unitprice_table) {
		this.unitprice_table = unitprice_table;
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
}
