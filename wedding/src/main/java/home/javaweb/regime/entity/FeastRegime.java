package home.javaweb.regime.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import home.javaweb.entity.FeastEntity;

@Entity
@Table(name = "feast_regime")
public class FeastRegime {

	@EmbeddedId
	private FeastRegimeId id;
	
	@ManyToOne
    @MapsId("feast_id")
    @JoinColumn(name = "feast_id")
    private FeastEntity feast;
	
	@ManyToOne
    @MapsId("regime_id")
    @JoinColumn(name = "regime_id")
    private Regime regime;

	
	private String note;

	public FeastRegimeId getId() {
		return id;
	}

	public void setId(FeastRegimeId id) {
		this.id = id;
	}

	public FeastEntity getFeast() {
		return feast;
	}

	public void setFeast(FeastEntity feast) {
		this.feast = feast;
	}


	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Regime getRegime() {
		return regime;
	}

	public void setRegime(Regime regime) {
		this.regime = regime;
	}
	
	
	

}
