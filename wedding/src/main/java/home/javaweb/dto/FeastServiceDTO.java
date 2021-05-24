package home.javaweb.dto;

import java.util.ArrayList;
import java.util.List;

import home.javaweb.entity.FeastEntity;

public class FeastServiceDTO {

	private List<ServiceCountDTO> services = new ArrayList<ServiceCountDTO>();
	
	private FeastEntity feast;
	
	private Long feastId;
	
	private Long serviceId;
	
	private int count;
	
	

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

	public List<ServiceCountDTO> getServices() {
		return services;
	}

	public void setServices(List<ServiceCountDTO> services) {
		this.services = services;
	}

	public FeastEntity getFeast() {
		return feast;
	}

	public void setFeast(FeastEntity feast) {
		this.feast = feast;
	}
	
	


}
