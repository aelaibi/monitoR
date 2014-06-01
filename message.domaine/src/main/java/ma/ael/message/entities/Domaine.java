package ma.ael.message.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ma.ael.message.object.BasicObject;

@Entity
@Table(name = "ref_domaine")
public class Domaine extends BasicObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3656756414137975953L;
	
	
	private Long idDomaine;
	private String nomDomaine;
	
	private Application application;
	
	@Id
	@GeneratedValue
	@Column(name="id_domaine", unique = true, nullable = false, length = 50)
	public Long getIdDomaine() {
		return idDomaine;
	}
	public void setIdDomaine(Long idDomaine) {
		this.idDomaine = idDomaine;
	}
	
	@Column(name="nom_domaine", nullable = false, length = 255)
	public String getNomDomaine() {
		return nomDomaine;
	}
	public void setNomDomaine(String nomDomaine) {
		this.nomDomaine = nomDomaine;
	}
	
	@ManyToOne
	@JoinColumn(name="application")
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
	
	
	
	
}
