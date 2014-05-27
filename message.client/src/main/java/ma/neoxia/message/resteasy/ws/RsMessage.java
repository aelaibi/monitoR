package ma.neoxia.message.resteasy.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ma.neoxia.message.bean.Erreur;
import ma.neoxia.message.bean.MessageBean;
import ma.neoxia.message.service.ApplicationService;
import ma.neoxia.message.service.DomaineService;
import ma.neoxia.message.service.MessageService;

import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Path("/rsmessage")
@Service
public class RsMessage implements IRsMessage {

	@Autowired
	MessageService messageService;
	@Autowired
	private ApplicationService applicationService;
	@Autowired
	private DomaineService domaineService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ma.neoxia.message.resteasy.ws.IRsMessage#index()
	 */
	@Override
	@GET
	@Produces("text/plain")
	public String index() {
		return "index rs webservice !!";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ma.neoxia.message.resteasy.ws.IRsMessage#getMessages()
	 */
	@BadgerFish
	@Override
	@GET
	@Path("/get")
	@Produces("application/json")
	public List<MessageBean> getMessages() {
		List<MessageBean> list = MessageBean
				.messageBeanFormatter(messageService.findAll());
		return list;
	}

	@BadgerFish
	@Override
	@POST
	@Path("/add")
	@Consumes("application/json")
	@Produces("application/json")
	public Erreur addMessage(MessageBean msg) {
		if (applicationService.findApplicationByName(msg.getNomApplication())
				.size() == 0) {
			return new Erreur("Application non existante", Long.valueOf(1));
		} else {
			if (domaineService.getDomainesOfApplicationByNames(
					msg.getNomApplication(), msg.getNomDomaine()).size() == 0) {
				return new Erreur("Domaine non existant", Long.valueOf(2));

			} else {
				msg.setIdDomaine(domaineService
						.getDomainesOfApplicationByNames(
								msg.getNomApplication(), msg.getNomDomaine())
						.get(0).getIdDomaine());
			}
		}
		messageService.save(msg);
		return new Erreur("Message Ajouté", Long.valueOf(0));

	}

}
