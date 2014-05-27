package ma.neoxia.message.resteasy.ws;

import java.util.List;

import ma.neoxia.message.bean.Erreur;
import ma.neoxia.message.bean.MessageBean;

public interface IRsMessage {

	public abstract String index();

	public abstract List<MessageBean> getMessages();
	
	public abstract Erreur addMessage(MessageBean msg);

}