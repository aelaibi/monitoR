package ma.ael.message.resteasy.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ma.ael.message.bean.Return;
import ma.ael.message.bean.MessageBean;
import ma.ael.message.service.ApplicationService;
import ma.ael.message.service.DomaineService;
import ma.ael.message.service.MessageService;

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
	 * @see ma.ael.message.resteasy.ws.IRsMessage#index()
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
	 * @see ma.ael.message.resteasy.ws.IRsMessage#getMessages()
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
	public Return addMessage(MessageBean msg) {
		
		messageService.add(msg);
		return new Return("Message Ajouté", Long.valueOf(0));

	}

}
