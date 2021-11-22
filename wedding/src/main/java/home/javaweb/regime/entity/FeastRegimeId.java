package home.javaweb.regime.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FeastRegimeId implements Serializable {

    @Column(name = "feast_id")
    Long feastId;

    @Column(name = "regime_id")
    Long regimeId;
    
    public FeastRegimeId() {
    	super();
    }
    
	public FeastRegimeId(Long feastId, Long regimeId) {
		super();
		this.feastId = feastId;
		this.regimeId = regimeId;
	}
}


