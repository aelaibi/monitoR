package ma.neoxia.message.bean;

import java.util.ArrayList;
import java.util.List;

import ma.neoxia.message.entities.Application;

import org.springframework.data.domain.Page;

public class ApplicationBean {

	private Long idApplication;
	private String nomApplication;
	
	public ApplicationBean(){
		
	}
	
	public ApplicationBean(Long idApplication, String nomApplication) {
		this.idApplication = idApplication;
		this.nomApplication = nomApplication;
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

	public static List<ApplicationBean> fromList(Page<Application> applications) {
		if (applications == null)
			return null;
		List<ApplicationBean> ret = new ArrayList<ApplicationBean>();
		for (Application application : applications) {
				ret.add(new ApplicationBean(Long.valueOf(application
					.getIdApplication()), application.getNomApplication()));
		}
		return ret;
	}

	public static List<ApplicationBean> fromList(List<Application> applications) {
		if (applications == null)
			return null;
		List<ApplicationBean> ret = new ArrayList<ApplicationBean>();
		for (Application application : applications) {
				ret.add(new ApplicationBean(Long.valueOf(application
					.getIdApplication()), application.getNomApplication()));
		}
		return ret;
	}
}
