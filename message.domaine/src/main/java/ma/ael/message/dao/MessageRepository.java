package ma.ael.message.dao;

import java.util.Date;
import java.util.List;

import ma.ael.message.entities.Message;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MessageRepository extends JpaRepository<Message, Long> { 
	
	List<Message> findByDateServerBetween( Date firstDate , Date secondDate );

	@Query("select distinct m.type from Message m ")
	List<String> findDistinctType();
	
	@Modifying
	@Query("update Message m set m.type = ?1 where m.idMessage = ?2")
	int setNewTypeForMessage(String type, Long idMessage);
	
	
	@Query
	("select m from Message m join m.domaine d where (m.dateServer BETWEEN ?1 AND ?2) AND m.type IN ?3 AND d.nomDomaine IN ?4 ORDER BY m.dateServer DESC ")
	List<Message> findByDateServerBetweenAndTypes(Date firstDate, Date secondDate,List<String> types,List<String> nomDomaine,Pageable pageable);
	@Query
	("select m from Message m join m.domaine d where (m.dateServer BETWEEN ?1 AND ?2) AND m.type IN ?3 AND d.nomDomaine IN ?4 ORDER BY m.dateServer DESC ")
	List<Message> findByDateServerBetweenAndTypes(Date firstDate, Date secondDate,List<String> types,List<String> nomDomaine);

	@Query
	("select m from Message m join m.domaine d join d.application a where (m.dateServer BETWEEN ?1 AND ?2) AND a.idApplication IN ?3 ORDER BY m.dateServer ASC ")
	List<Message> findByDateServerBetweenAndApplicationId(Date firstDate, Date secondDate,Long idApplication);


}
