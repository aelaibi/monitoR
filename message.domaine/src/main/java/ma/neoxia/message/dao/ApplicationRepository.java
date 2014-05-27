package ma.neoxia.message.dao;

import java.util.List;

import ma.neoxia.message.entities.Application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

	@Modifying
	@Query("update Application a set a.nomApplication = ?1 where a.idApplication = ?2")
	int editApplication(String nomApplication, Long idApplication);

	@Query("select a from Application a")
	Page<Application> findAllByLimits(Pageable pageable);

	@Query("select a from Application a where a.nomApplication = ?1")
	List<Application> findApplicationByName(String nomApplication);
}
