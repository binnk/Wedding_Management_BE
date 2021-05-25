package home.javaweb.dto;

import java.util.ArrayList;
import java.util.List;

import home.javaweb.entity.FeastEntity;

public class FeastServiceDTO {
	
	private FeastEntity feast;
	private List<ServiceSupport> services = new ArrayList<ServiceSupport>();
	private Long feastId;	
	private Long serviceId;	
	private int count;	
	private Long totalPrice;	
	private String note;
	
	

	public Long getFeastId() {
		return feastId;
	}

	public void setFeastId(Long feastId) {
		this.feastId = feastId;
	}
		

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public List<ServiceSupport> getServices() {
		return services;
	}

	public void setServices(List<ServiceSupport> services) {
		this.services = services;
	}

	public FeastEntity getFeast() {
		return feast;
	}

	public void setFeast(FeastEntity feast) {
		this.feast = feast;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	


}
