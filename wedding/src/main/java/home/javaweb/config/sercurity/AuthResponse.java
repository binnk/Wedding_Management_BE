package home.javaweb.config.sercurity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import home.javaweb.entity.Privilege;

public class AuthResponse implements Serializable {
	
	
	private String username;
	private String image;
	private String fullname;
    private String token;
    private String role;
    private List<Privilege> privileges = new ArrayList<>();
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

    public AuthResponse(String token, String username, String fullname, String image, String role,List<Privilege> privileges) {
        this.token = token;
        this.username = username;
        this.fullname = fullname;
        this.image = image;
        this.role = role;
        this.privileges = privileges;
    }
    public AuthResponse(String token) {
    	this.token = token;
    }
    
    public String getToken() {
    
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
   public String getRole() {
		return role;
	}

  public void setRole(String role) {
		this.role = role;
	}

public List<Privilege> getPrivileges() {
	return privileges;
}

public void setPrivileges(List<Privilege> privileges) {
	this.privileges = privileges;
}

}

