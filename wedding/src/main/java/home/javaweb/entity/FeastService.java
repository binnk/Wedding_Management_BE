package home.javaweb.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import home.javaweb.embeddable.FeastServiceId;

@Entity(name="FeastService")
@Table(name = "feast_service")
public class FeastService {
	
	@EmbeddedId
	private FeastServiceId id ;
	
	@ManyToOne
	@MapsId("feastId")
	private FeastEntity feast;
	
	@ManyToOne
	@MapsId("serviceId")
	private Service service;
	
	
	@Column(name = "count")
	private int count;
	
	@Column(name = "unit_price")
	private Long unitPrice;
	
	@Column(name = "total_price")
	private Long totalPrice;
	
	@Column(name = "note")
	private String note;
	

	public FeastServiceId getId() {
		return id;
	}

	public void setId(FeastServiceId id) {
		this.id = id;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public FeastEntity getFeast() {
		return feast;
	}

	public void setFeast(FeastEntity feast) {
		this.feast = feast;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Long unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
	
	
}
