package ma.ael.message.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;

import ma.ael.message.bean.MessageBean;
import ma.ael.message.entities.Message;

public interface MessageService {
	
	long count();

	List<Message> findByDateServerBetween(Date firstDate, Date secondDate);
	
	List<String> findDistinctTypes();
	long save(MessageBean msgBean);
	List<Message> findAll();

	List<Message> findByDateServerBetweenAndTypes(Date firstDate,
			Date secondDate,List<String> types,List<String> nomDomaine,Pageable pageable);
	List<Message> findByDateServerBetweenAndTypes(Date firstDate,
			Date secondDate,List<String> types,List<String> nomDomaine);

	List<Message> findByDateServerBetweenAndApplicationId(Date firstDate, Date secondDate,Long idApplication);

	long saveWithRules(MessageBean msgBean);

}
