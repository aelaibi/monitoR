package ma.ael.message.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ma.ael.message.entities.Message;

@XmlRootElement(name = "mb")
public class MessageBean {


	private Long idMessage;
	
	private String type;
	private String message;
	private String description;
	private Date dateEnvoi;
	private Date dateServer;
	
	private Long idDomaine;
	private String nomDomaine;
	
	private Long idApplication;
	private String nomApplication;
	
	@XmlElement
	public Long getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(Long idMessage) {
		this.idMessage = idMessage;
	}
	@XmlAttribute
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@XmlElement
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@XmlElement
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@XmlElement
	public Date getDateEnvoi() {
		return dateEnvoi;
	}
	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}
	@XmlElement
	public Date getDateServer() {
		return dateServer;
	}
	public void setDateServer(Date dateServer) {
		this.dateServer = dateServer;
	}
	@XmlElement
	public Long getIdDomaine() {
		return idDomaine;
	}
	public void setIdDomaine(Long idDomaine) {
		this.idDomaine = idDomaine;
	}
	@XmlElement
	public String getNomDomaine() {
		return nomDomaine;
	}
	public void setNomDomaine(String nomDomaine) {
		this.nomDomaine = nomDomaine;
	}
	@XmlElement
	public Long getIdApplication() {
		return idApplication;
	}
	public void setIdApplication(Long idApplication) {
		this.idApplication = idApplication;
	}
	@XmlElement
	public String getNomApplication() {
		return nomApplication;
	}
	public void setNomApplication(String nomApplication) {
		this.nomApplication = nomApplication;
	}
	
	public static List<MessageBean> messageBeanFormatter(List<Message> listMessage) {
		List<MessageBean> msgBeanList = new ArrayList<MessageBean>();
		
		for (Message message : listMessage) {
			MessageBean tmpBean = new MessageBean();
			tmpBean.idMessage      = message.getIdMessage();
			tmpBean.dateEnvoi  	   = message.getDateEnvoi();
			tmpBean.dateServer 	   = message.getDateServer();
			tmpBean.description    = message.getDescription();
			tmpBean.message        = message.getMessage();
			tmpBean.type           = message.getType();
			tmpBean.idDomaine      = message.getDomaine().getIdDomaine();
			tmpBean.nomDomaine     = message.getDomaine().getNomDomaine();
			tmpBean.idApplication  = message.getDomaine().getApplication().getIdApplication();
			tmpBean.nomApplication = message.getDomaine().getApplication().getNomApplication();
			msgBeanList.add(tmpBean);
		}
		return msgBeanList;
	}
	
	
	
}
