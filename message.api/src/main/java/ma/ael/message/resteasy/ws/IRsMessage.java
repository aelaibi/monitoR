package ma.ael.message.resteasy.ws;

import java.util.List;

import ma.ael.message.bean.Return;
import ma.ael.message.bean.MessageBean;

public interface IRsMessage {

	public abstract String index();

	public abstract List<MessageBean> getMessages();
	
	public abstract Return addMessage(MessageBean msg);

}