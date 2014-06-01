package ma.ael.message.service.impl;

import java.util.List;

import ma.ael.message.bean.DomaineBean;
import ma.ael.message.dao.ApplicationRepository;
import ma.ael.message.dao.DomaineRepository;
import ma.ael.message.entities.Application;
import ma.ael.message.entities.Domaine;
import ma.ael.message.service.DomaineService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DomaineServiceImpl implements DomaineService {
	
	private static Logger logger = LoggerFactory.getLogger( DomaineServiceImpl.class );
	
	@Autowired
	private DomaineRepository domaineRepository;
	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Override
	public long count() {
		logger.debug("Count : " + domaineRepository.count());
		return domaineRepository.count();
	}

	@Override
	public List<Domaine> findAll() {
		return domaineRepository.findAll();
	}

	@Override
	public Page<Domaine> findDomainesOfApplication(Long idApplication , Pageable pageable) {
		return domaineRepository.listDomainesOfApplication(idApplication , pageable);
	}

	@Override
	public int editDomaine(Long idDomaine, String nomDomaine) {
		return domaineRepository.editApplication(nomDomaine, idDomaine);
	}

	@Override
	public void save(DomaineBean domaineBean) {
		Domaine domaine = new Domaine();
		Application application = new Application();
		application = applicationRepository.findOne(domaineBean.getIdApplication());
		domaine.setNomDomaine(domaineBean.getNomDomaine());
		domaine.setApplication(application);
		domaineRepository.save(domaine);
	}

	@Override
	public void delete(DomaineBean domaineBean) {
		Domaine domaine = new Domaine();
		domaine.setIdDomaine(domaineBean.getIdDomaine());
		domaineRepository.delete(domaine);
	}
	@Override
	public List<Domaine> getDomainesOfApplicationByNames(String nomApplication , String nomDomaine)
	{
		return domaineRepository.getDomainesOfApplicationByNames(nomApplication, nomDomaine);
	}
}