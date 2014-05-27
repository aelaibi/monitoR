package ma.neoxia.message.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import ma.neoxia.message.object.BasicObject;

public class ProfilRole extends BasicObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2269921242024133188L;
	
	private Long id;
	private Profil profil;
	private Role role;
	
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false, length = 50)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "profile", nullable = false, length = 50)
	public Profil getProfil() {
		return profil;
	}
	public void setProfil(Profil profil) {
		this.profil = profil;
	}
	
	@Column(name = "role", nullable = false, length = 50)
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
	
	
	

}
