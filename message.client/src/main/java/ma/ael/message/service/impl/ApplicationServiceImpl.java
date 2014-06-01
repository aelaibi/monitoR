package ma.ael.message.service.impl;

import java.util.List;

import ma.ael.message.bean.ApplicationBean;
import ma.ael.message.dao.ApplicationRepository;
import ma.ael.message.entities.Application;
import ma.ael.message.service.ApplicationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {
	
	private static Logger logger = LoggerFactory.getLogger( ApplicationServiceImpl.class );
	
	@Autowired
	private ApplicationRepository applicationRepository;

	@Override
	public long count() {
		logger.debug("Count : " + applicationRepository.count() );
		return applicationRepository.count();
	}

	@Override
	public List<Application> findAll() {
		return applicationRepository.findAll();
	}

	@Override
	public int editApplication(long id, String application) {
		return applicationRepository.editApplication(application, id);
	}

	@Override
	public void save(ApplicationBean applicationBean) {
		Application application = new Application();
		application.setNomApplication(applicationBean.getNomApplication());
		application = applicationRepository.save(application);
		logger.debug("save application  : " + application.getNomApplication() );
	}

	@Override
	public void delete(ApplicationBean applicationBean) {
		logger.debug("delete application  : " + applicationBean.getNomApplication() );
		Application application = new Application();
		application.setIdApplication(applicationBean.getIdApplication());
		applicationRepository.delete(application);
	}

	@Override
	public Page<Application> findAllByLimits(Pageable pageable) {
		return applicationRepository.findAllByLimits(pageable);
	}
	@Override
	public List<Application> findApplicationByName(String nomApplication){
		
		return applicationRepository.findApplicationByName(nomApplication);
	}

}