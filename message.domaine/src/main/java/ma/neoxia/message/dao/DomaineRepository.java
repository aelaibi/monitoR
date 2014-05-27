package ma.neoxia.message.dao;

import java.util.List;

import ma.neoxia.message.entities.Domaine;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface DomaineRepository extends JpaRepository<Domaine, Long> { 
	
	@Query("select d from Domaine d where application.nomApplication = ?1 and d.nomDomaine = ?2")
	List<Domaine> getDomainesOfApplicationByNames(String nomApplication , String nomDomaine);
	
	
	@Query("select d from Domaine d where application.idApplication = ?1")
	Page<Domaine> listDomainesOfApplication(Long idApplication , Pageable pageable);
	
	@Modifying
	@Query("update Domaine d set d.nomDomaine = ?1 where d.idDomaine = ?2")
	int editApplication(String nomDomaine, Long idDomaine);
	
}
