package home.javaweb.entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "feast")
public class FeastEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "groomname")
	private String groomname;
	@Column(name = "bridename")
	private String bridename;
	@Column(name = "phone")
	private String phone;
	@Column(name = "wedding_date")
	@Temporal(TemporalType.DATE)
	private Date wedding_date;
	@ManyToOne
	@JoinColumn(name = "shift_id")
	private ShiftEntity shift;
	@ManyToOne
	@JoinColumn(name = "lobby_id")
	private  LobbyEntity lobby;
	@Column(name = "number_of_tables")
	private Long number_of_tables;
	@Column(name = "estimated_number_of_tables")
	private Long estimated_number_of_tables;
	@Column(name = "unitprice_table")
	private Float unitprice_table;
	@Column(name = "deposit")
	private Float deposit;
	@Column(name = "note")
	private String note;
	
	@OneToMany(mappedBy = "feast")
	private List<FeastService> feastServices = new ArrayList<FeastService>();
	
	@OneToMany(mappedBy = "feast")
	private List<FeastTable> feastTables = new ArrayList<FeastTable	>();
	
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
	public ShiftEntity getshift() {
		return shift;
	}
	public void setshift(ShiftEntity shift) {
		this.shift = shift;
	}
	public LobbyEntity getId_lobby() {
		return lobby;
	}
	public void setId_lobby(LobbyEntity optional) {
		this.lobby = optional;
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
	
	public List<FeastService> getFeastServices() {
		return feastServices;
	}
	public void setFeastServices(List<FeastService> feastServices) {
		this.feastServices = feastServices;
	}
	
	
	
}