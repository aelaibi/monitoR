package ma.ael.message.service.impl;

import java.util.Date;
import java.util.List;

import ma.ael.message.bean.MessageBean;
import ma.ael.message.dao.ApplicationRepository;
import ma.ael.message.dao.DomaineRepository;
import ma.ael.message.dao.MessageRepository;
import ma.ael.message.entities.Application;
import ma.ael.message.entities.Domaine;
import ma.ael.message.entities.Message;
import ma.ael.message.service.MessageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

	private static Logger logger = LoggerFactory
			.getLogger(MessageServiceImpl.class);

	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private DomaineRepository domaineRepository;
	@Autowired
	private ApplicationRepository applicationRepository;

	@Override
	public long count() {
		return messageRepository.count();
	}

	@Override
	public List<Message> findByDateServerBetween(Date firstDate, Date secondDate) {
		if (firstDate != null && secondDate != null) {
			return messageRepository.findByDateServerBetween(firstDate,
					secondDate);
		}
		return messageRepository.findAll();
	}

	@Override
	public long save(MessageBean msgBean) {
		Message msg = new Message();
		Domaine domaine;

		msg.setDateEnvoi(msgBean.getDateEnvoi());
		msg.setDateServer(new Date());
		msg.setMessage(msgBean.getMessage());
		msg.setType(msgBean.getType());
		msg.setDescription(msgBean.getDescription());

		if (msgBean.getIdDomaine() != null) {
			domaine = new Domaine();
			domaine.setIdDomaine(msgBean.getIdDomaine());
			msg.setDomaine(domaine);
			messageRepository.save(msg);
			return msg.getIdMessage();
		} 
		return -1;

	}
	
	@Override
	public long saveWithRules(MessageBean msgBean) {
		Message msg = new Message();
		Domaine domaine;
		Application application;

		msg.setDateEnvoi(msgBean.getDateEnvoi());
		msg.setDateServer(new Date());
		msg.setMessage(msgBean.getMessage());
		msg.setType(msgBean.getType());
		msg.setDescription(msgBean.getDescription());

		if (msgBean.getIdDomaine() != null) {
			domaine = domaineRepository.findOne(msgBean.getIdDomaine());
			if (domaine != null) {
				msg.setDomaine(domaine);
				messageRepository.save(msg);
				return msg.getIdMessage();
			} else {
				logger.error("domain id not found !!! {}",
						msgBean.getIdDomaine());

			}
		} else {
			if (msgBean.getNomDomaine() != null) {
				domaine = new Domaine();
				domaine.setNomDomaine(msgBean.getNomDomaine());
				if (msgBean.getIdApplication() != null) {
					application = applicationRepository.findOne(msgBean
							.getIdApplication());
					if (application == null) {
						logger.error("application id not found !!! {}",
								msgBean.getIdApplication());
						return msg.getIdMessage();
					}
					domaine.setApplication(application);
					domaine = domaineRepository.save(domaine);
					msg.setDomaine(domaine);
					messageRepository.save(msg);
					return msg.getIdMessage();
				} else {
					if (msgBean.getNomApplication() != null) {
						application = new Application();
						application.setNomApplication(msgBean
								.getNomApplication());
						application = applicationRepository.save(application);
						domaine.setApplication(application);
						domaine = domaineRepository.save(domaine);
						msg.setDomaine(domaine);
						messageRepository.save(msg);
					} else {
						logger.error("nom appli null");
						return msg.getIdMessage();
					}
				}
			}
		}
		return 0;

	}

	@Override
	public List<Message> findAll() {
		return messageRepository.findAll();
	}

	@Override
	public List<String> findDistinctTypes() {
		return messageRepository.findDistinctType();
	}
	@Override
	public
	List<Message> findByDateServerBetweenAndTypes(Date firstDate,Date secondDate,List<String> types,List<String> nomDomaine,Pageable pageable) {
	
		
		return messageRepository.findByDateServerBetweenAndTypes(firstDate,
					secondDate,types,nomDomaine,pageable);
	}

	@Override
	public
	List<Message> findByDateServerBetweenAndTypes(Date firstDate,Date secondDate,List<String> types,List<String> nomDomaine) {
	
		
		return messageRepository.findByDateServerBetweenAndTypes(firstDate,
					secondDate,types,nomDomaine);
	}

	@Override
	public List<Message> findByDateServerBetweenAndApplicationId(
			Date firstDate, Date secondDate, Long idApplication) {
		
		return messageRepository.findByDateServerBetweenAndApplicationId(firstDate, secondDate, idApplication);
	}
}