package home.javaweb.dto;

public class ShiftDTO {
	
	private Long id;
    private String name;
    private String timeBegin;
    private String timeEnd;
    
    public ShiftDTO () {};
    public ShiftDTO id (Long id) {
    	this.id = id;
    	return this; 	
    }
    public ShiftDTO name (String name) {
    	this.name = name;
    	return this; 	
    }
    public ShiftDTO timeBegin (String timeBegin) {
    	this.timeBegin = timeBegin;
    	return this; 	
    }
    public ShiftDTO timeEnd (String timeEnd) {
    	this.timeEnd = timeEnd;
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
	public String getTimeBegin() {
		return timeBegin;
	}
	public void setTimeBegin(String timeBegin) {
		this.timeBegin = timeBegin;
	}
	public String getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}
	
}
