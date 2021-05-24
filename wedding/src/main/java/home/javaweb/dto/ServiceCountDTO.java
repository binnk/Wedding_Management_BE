package home.javaweb.dto;

import home.javaweb.entity.Service;

public class ServiceCountDTO {
	private Service service;
	
	private int count;
	

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
