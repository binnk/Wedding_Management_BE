package home.javaweb.config.sercurity;

import java.io.Serializable;

public class AuthResponse implements Serializable {
	private String username;
	private String image;
	private String fullname;
    private String token;
    
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

    public AuthResponse(String token, String username, String fullname, String image) {
        this.token = token;
        this.username = username;
        this.fullname = fullname;
        this.image = image;
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

}

