package ma.neoxia.message.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import ma.neoxia.message.object.BasicObject;

@Entity
@Table(name = "hab_profil")
public class Profil extends BasicObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9105386229126798667L;
	
	private Long idProfil;
	private String type;
	
	private Set<Domaine> domaines;
	private Set<Role> roles;
	
	
	@Id
	@GeneratedValue
	@Column(name = "id_profil", unique = true, nullable = false, length = 50)
	public Long getIdProfil() {
		return idProfil;
	}
	public void setIdProfil(Long idProfil) {
		this.idProfil = idProfil;
	}
	
	@Column(name = "type", nullable = false, length = 255)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "hab_profilrole", joinColumns = { @JoinColumn(name = "idprofil") }, 
	inverseJoinColumns = { @JoinColumn(name = "idrole") })
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ref_profildomaine", joinColumns = { @JoinColumn(name = "idprofil") }, 
	inverseJoinColumns = { @JoinColumn(name = "iddomaine") })
	public Set<Domaine> getDomaines() {
		return domaines;
	}
	public void setDomaines(Set<Domaine> domaines) {
		this.domaines = domaines;
	}
	
	
	
}
