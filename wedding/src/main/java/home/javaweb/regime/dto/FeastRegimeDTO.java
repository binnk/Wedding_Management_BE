package home.javaweb.regime.dto;

import java.util.ArrayList;

public class FeastRegimeDTO {
	private Long feastId;
	private ArrayList<Long> oldRegimeId = new ArrayList<Long>();
	private ArrayList<Long> newRegimeId = new ArrayList<Long>();;
	
	
	public Long getFeastId() {
		return feastId;
	}
	public void setFeastId(Long feastId) {
		this.feastId = feastId;
	}
	public ArrayList<Long> getOldRegimeId() {
		return oldRegimeId;
	}
	public void setOldRegimeId(ArrayList<Long> oldRegimeId) {
		this.oldRegimeId = oldRegimeId;
	}
	public ArrayList<Long> getNewRegimeId() {
		return newRegimeId;
	}
	public void setNewRegimeId(ArrayList<Long> newRegimeId) {
		this.newRegimeId = newRegimeId;
	}


}
