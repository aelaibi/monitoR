package ma.neoxia.message.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ma.neoxia.message.object.BasicObject;

@Entity
@Table(name = "hab_utilisateur")
public class Utilisateur extends BasicObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4227394007266682042L;
	
	private Long idUtilisateur;
	private String nom;
	private String prenom;
	private String login;
	private String motDePasse;
	
	private Profil profil;
	
	
	@Id
	@GeneratedValue
	@Column(name = "id_Utilisateur", unique = true, nullable = false, length = 50)
	public Long getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	@Column(name = "nom", nullable = false, length = 255)
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "prenom", nullable = false, length = 255)
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "motdepasse", nullable = false, length = 32)
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	@Column(name = "login", nullable = false, length = 255)
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	@ManyToOne
	@JoinColumn(name = "profil")
	public Profil getProfil() {
		return profil;
	}
	public void setProfil(Profil profil) {
		this.profil = profil;
	}
	
}
