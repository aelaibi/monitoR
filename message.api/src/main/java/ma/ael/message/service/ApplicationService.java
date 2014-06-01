package ma.ael.message.service;

import java.util.List;

import ma.ael.message.bean.ApplicationBean;
import ma.ael.message.dao.ApplicationRepository;
import ma.ael.message.entities.Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ApplicationService {
	
	private static Logger logger = LoggerFactory.getLogger( ApplicationService.class );
	
	@Autowired
	private ApplicationRepository applicationRepository;

	
	public long count() {
		logger.debug("Count : " + applicationRepository.count() );
		return applicationRepository.count();
	}

	
	public List<Application> findAll() {
		return applicationRepository.findAll();
	}

	
	public int editApplication(long id, String application) {
		return applicationRepository.editApplication(application, id);
	}

	
	public void save(ApplicationBean applicationBean) {
		Application application = new Application();
		application.setNomApplication(applicationBean.getNomApplication());
		application = applicationRepository.save(application);
		logger.debug("save application  : " + application.getNomApplication() );
	}

	
	public void delete(ApplicationBean applicationBean) {
		logger.debug("delete application  : " + applicationBean.getNomApplication() );
		Application application = new Application();
		application.setIdApplication(applicationBean.getIdApplication());
		applicationRepository.delete(application);
	}

	
	public Page<Application> findAllByLimits(Pageable pageable) {
		return applicationRepository.findAllByLimits(pageable);
	}
	
	public List<Application> findApplicationByName(String nomApplication){
		
		return applicationRepository.findApplicationByName(nomApplication);
	}

}