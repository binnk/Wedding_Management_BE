package home.javaweb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Privilege implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;
    private String description;
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    public Privilege() {
    }
    public Privilege(String authority, String description) {
        this.authority = authority;
        this.description = description;
    }

    public Privilege(String authority) {
        this.authority = authority;
       this.description = "";
    }
    public Privilege(long id, String authority) {
        this.authority = authority;
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }


    @Override
    public String getAuthority() {
        return authority;
    }

    @Override
    public String toString() {
        return "Privilege{" +
                "id=" + id +
                ", authority='" + authority + '\'' +
                '}';
    }
}