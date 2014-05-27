package ma.neoxia.message.service;

import java.util.List;

import ma.neoxia.message.bean.ApplicationBean;
import ma.neoxia.message.entities.Application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ApplicationService {
	
	long count();
	
	List<Application> findAll();
	
	int editApplication(long id , String application);
	
	void save(ApplicationBean applicationBean);
	
	void delete(ApplicationBean applicationBean);
	
	Page<Application> findAllByLimits(Pageable pageable);

	List<Application> findApplicationByName(String nomApplication);
}
