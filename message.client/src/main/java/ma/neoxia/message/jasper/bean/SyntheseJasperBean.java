package ma.neoxia.message.jasper.bean;

import java.util.Date;


public class SyntheseJasperBean {

	private String type;
	private String correspondant;
	private Date date;
	private String objet;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCorrespondant() {
		return correspondant;
	}

	public void setCorrespondant(String correspondant) {
		this.correspondant = correspondant;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

}
