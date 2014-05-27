package ma.neoxia.message.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import ma.neoxia.message.object.BasicObject;

@Entity
@Table(name = "ref_application")
public class Application extends BasicObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7779813176777504343L;
	
	private Long idApplication;
	private String nomApplication;
	
	
	@Id
	@GeneratedValue
	@Column(name="id_application", unique = true, nullable = false, length = 55)
	public Long getIdApplication() {
		return idApplication;
	}
	public void setIdApplication(Long idApplication) {
		this.idApplication = idApplication;
	}
	
	@Column(name="nom_application", nullable = false, length = 255)
	public String getNomApplication() {
		return nomApplication;
	}
	public void setNomApplication(String nomApplication) {
		this.nomApplication = nomApplication;
	}
	
	
}
