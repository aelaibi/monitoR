package ma.ael.message.service;

import java.util.Date;
import java.util.List;

import ma.ael.message.bean.MessageBean;
import ma.ael.message.dao.ApplicationRepository;
import ma.ael.message.dao.DomaineRepository;
import ma.ael.message.dao.MessageRepository;
import ma.ael.message.entities.Application;
import ma.ael.message.entities.Domaine;
import ma.ael.message.entities.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessageService {

	private static Logger logger = LoggerFactory.getLogger(MessageService.class);

	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private DomaineRepository domaineRepository;
	@Autowired
	private ApplicationRepository applicationRepository;

	
	public long count() {
		return messageRepository.count();
	}

	
	public List<Message> findByDateServerBetween(Date firstDate, Date secondDate) {
		if (firstDate != null && secondDate != null) {
			return messageRepository.findByDateServerBetween(firstDate,
					secondDate);
		}
		return messageRepository.findAll();
	}

	
	
	
	
	

	
	public List<Message> findAll() {
		return messageRepository.findAll();
	}

	
	public List<String> findDistinctTypes() {
		return messageRepository.findDistinctType();
	}
	
	public
	List<Message> findByDateServerBetweenAndTypes(Date firstDate,Date secondDate,List<String> types,List<String> nomDomaine,Pageable pageable) {
	
		
		return messageRepository.findByDateServerBetweenAndTypes(firstDate,
					secondDate,types,nomDomaine,pageable);
	}

	
	public
	List<Message> findByDateServerBetweenAndTypes(Date firstDate,Date secondDate,List<String> types,List<String> nomDomaine) {
	
		
		return messageRepository.findByDateServerBetweenAndTypes(firstDate,
					secondDate,types,nomDomaine);
	}

	
	public List<Message> findByDateServerBetweenAndApplicationId(
			Date firstDate, Date secondDate, Long idApplication) {
		
		return messageRepository.findByDateServerBetweenAndApplicationId(firstDate, secondDate, idApplication);
	}


	public void add(MessageBean msgBean) {
		Message msg = new Message();
		Domaine domaine;

		msg.setDateEnvoi(new Date());
		msg.setMessage(msgBean.getMessage());
		msg.setType(msgBean.getType());
		msg.setDescription(msgBean.getDescription());
		domaine = domaineRepository.findByNomDomaine(msgBean.getNomDomaine());
		if(domaine == null){
			domaine = new Domaine();
			domaine.setNomDomaine(msgBean.getNomDomaine());
			
			Application app = applicationRepository.findByNomApplication(msgBean.getNomApplication());
			if(app == null){
				app = new Application();
				app.setNomApplication(msgBean.getNomApplication());
				applicationRepository.save(app);
			}
			domaine.setApplication(app);
			domaineRepository.save(domaine);
		}
		
		
		msg.setDomaine(domaine);
		messageRepository.save(msg);
		
	}
}