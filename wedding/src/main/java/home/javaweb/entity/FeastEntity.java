package home.javaweb.entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import home.javaweb.regime.entity.Regime;


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
	private LocalDate dateOfOrganization; 
	@Column(name = "deposit")
	private Float deposit;
	@Column(name = "note")
	private String note;
	@ManyToOne
	@JoinColumn(name = "shift_id")
	private ShiftEntity shift;
	@ManyToOne
	@JoinColumn(name = "lobby_id")
	private  LobbyEntity lobby;
	
	private Long regimeRefund;
	private Long weddingRefund;

	
	@OneToMany(mappedBy = "feast")
	@JsonIgnore
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
	public LocalDate getDateOfOrganization() {
		return dateOfOrganization;
	}
	public void setDateOfOrganization(LocalDate dateOfOrganization) {
		this.dateOfOrganization = dateOfOrganization;
	}
	public Long getRegimeRefund() {
		return regimeRefund;
	}
	public void setRegimeRefund(Long totalRefund) {
		this.regimeRefund = totalRefund;
	}
	public Long getWeddingRefund() {
		return weddingRefund;
	}
	public void setWeddingRefund(Long weddingRefund) {
		this.weddingRefund = weddingRefund;
	}

	
	
	
	
}