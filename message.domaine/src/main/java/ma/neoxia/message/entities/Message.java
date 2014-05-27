package ma.neoxia.message.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ma.neoxia.message.object.BasicObject;

@Entity
@Table(name = "ref_message")
public class Message extends BasicObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4909003417217275405L;
	
	private Long idMessage;
	private String type;
	private String message;
	private String description;
	private Date dateEnvoi;
	private Date dateServer;
	private Domaine domaine;

	@Id
	@GeneratedValue
	@Column(name="id_message", unique = true, nullable = false, length = 50)
	public Long getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(Long idMessage) {
		this.idMessage = idMessage;
	}
	
	@Column(name="type", nullable = false, length = 255)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Column(name="message", nullable = false, length = 255)
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name="description", nullable = false, length = 255)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="dateenvoi", nullable = false, length = 255)
	public Date getDateEnvoi() {
		return dateEnvoi;
	}
	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}
	
	
	public Date getDateServer() {
		return dateServer;
	}
	public void setDateServer(Date dateServer) {
		this.dateServer = dateServer;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="domaine")
	public Domaine getDomaine() {
		return domaine;
	}
	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}
	
	
	
	
}
