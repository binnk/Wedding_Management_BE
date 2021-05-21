package home.javaweb.embeddable;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class FeastServiceId implements Serializable {
	
	private Long feastId;
	
	private Long serviceId;
}
