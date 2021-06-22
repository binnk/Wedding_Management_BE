package home.javaweb.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "shift")
public class ShiftEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "time_begin")
	//@Temporal(TemporalType.TIME)
	private Time timeBegin;
	@Column(name = "time_end")
	//@Temporal(TemporalType.TIME)
	private Time timeEnd;
	@JsonIgnore
	private Boolean active;
	public ShiftEntity () {};
	
	public ShiftEntity id(Long id) {
		this.id = id;
		return this;
	}
	public ShiftEntity name(String name) {
		this.name = name;
		return this;
	}
	public ShiftEntity timeBegin(Time timeBegin) {
		this.timeBegin = timeBegin;
		return this;
	}
	public ShiftEntity timeEnd(Time timeEnd) {
		this.timeEnd = timeEnd;
		return this;
	}
	public ShiftEntity active(Boolean active) {
		this.active = active;
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
	public Time getTimeBegin() {
		return timeBegin;
	}
	public void setTimeBegin(Time timeBegin) {
		this.timeBegin = timeBegin;
	}
	public Time getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(Time timeEnd) {
		this.timeEnd = timeEnd;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
}
