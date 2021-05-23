package home.javaweb.embeddable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FeastServiceId implements Serializable {
	

	@Column(name = "feast_id")
	private Long feastId;
	
	@Column(name = "service_id")
	private Long serviceId;
	
	

	public FeastServiceId() {
		super();
	}



	public FeastServiceId(Long feastId, Long serviceId) {
		super();
		this.feastId = feastId;
		this.serviceId = serviceId;
	}
	
	
}
