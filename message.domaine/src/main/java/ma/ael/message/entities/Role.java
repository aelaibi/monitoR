package ma.ael.message.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import ma.ael.message.object.BasicObject;

@Entity
@Table(name = "hab_role")
public class Role extends BasicObject {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4273434093257098854L;
	
	private Long idRole;
	private String role;
	
	
	
	@Id
	@GeneratedValue
	@Column(name = "id_role", unique = true, nullable = false, length = 50)
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	@Column(name = "role", nullable = false, length = 255)
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
	
}
