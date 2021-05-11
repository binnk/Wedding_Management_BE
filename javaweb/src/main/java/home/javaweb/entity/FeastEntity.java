package home.javaweb.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feast")
public class FeastEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "groomname")
	private String groomname;
	@Column(name = "bridemname")
	private String bridename;
	@Column(name = "phone")
	private String phone;
	@Column(name = "wedding_date") // columnDefinition = "DATE DEFAULT CURRENT_DATE"
	private Date wedding_date;
	@Column(name = "id_shift")
	private Long id_shift;
	@OneToOne
	@JoinColumn(name = "lobby_id")
	private  LobbyEntity lobby;
	@Column(name = "number_of_tables")
	private Long number_of_tables;
	@Column(name = "estimated_number_of_tables")
	private Long estimated_number_of_tables;
	@Column(name = "unitprice_table")
	private float unitprice_table;
	@Column(name = "deposit")
	private float deposit;
	@Column(name = "note")
	private String note;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public LobbyEntity getId_lobby() {
		return lobby;
	}
	public void setId_lobby(LobbyEntity lobby) {
		this.lobby = lobby;
	}
	public Long getNumber_of_table() {
		return number_of_tables;
	}
	public void setNumber_of_table(Long number_of_table) {
		this.number_of_tables = number_of_table;
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