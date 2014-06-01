package ma.ael.message.service;

import java.util.List;

import ma.ael.message.bean.DomaineBean;
import ma.ael.message.entities.Domaine;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface DomaineService {
	
	long count();
	
	List<Domaine> findAll();
	
	Page<Domaine> findDomainesOfApplication(Long idApplication , Pageable pageable);
	
	int editDomaine(Long idDomaine,String nomDomaine);
	
	void save(DomaineBean domaineBean);
	
	void delete(DomaineBean domaineBean);
	
	List<Domaine> getDomainesOfApplicationByNames(String nomApplication , String nomDomaine);
}
