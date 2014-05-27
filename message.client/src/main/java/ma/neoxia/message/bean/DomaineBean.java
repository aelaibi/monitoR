package ma.neoxia.message.bean;

import java.util.ArrayList;
import java.util.List;

import ma.neoxia.message.entities.Domaine;

import org.springframework.data.domain.Page;

public class DomaineBean {
	
	private Long idDomaine;
	private String nomDomaine;
	private Long idApplication;
	private String nomApplication;
	
	
	public Long getIdDomaine() {
		return idDomaine;
	}
	public void setIdDomaine(Long idDomaine) {
		this.idDomaine = idDomaine;
	}

	public String getNomDomaine() {
		return nomDomaine;
	}
	public void setNomDomaine(String nomDomaine) {
		this.nomDomaine = nomDomaine;
	}

	public Long getIdApplication() {
		return idApplication;
	}
	public void setIdApplication(Long idApplication) {
		this.idApplication = idApplication;
	}

	public String getNomApplication() {
		return nomApplication;
	}
	public void setNomApplication(String nomApplication) {
		this.nomApplication = nomApplication;
	}

	public static List<DomaineBean> fromList(Page<Domaine> domaines) {
		List<DomaineBean> ret = new ArrayList<DomaineBean>();
		if(domaines == null) {
			return null;
		} else {
			for (Domaine domaine : domaines) {
				DomaineBean tmpDomaineBean = new DomaineBean();
				tmpDomaineBean.setIdDomaine(domaine.getIdDomaine());
				tmpDomaineBean.setNomDomaine(domaine.getNomDomaine());
				tmpDomaineBean.setIdApplication(domaine.getApplication().getIdApplication());
				tmpDomaineBean.setNomApplication(domaine.getApplication().getNomApplication());
				ret.add(tmpDomaineBean);
			}
		}
		
		return ret;
	}
	
	}
