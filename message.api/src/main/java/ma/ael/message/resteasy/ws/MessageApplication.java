package ma.ael.message.resteasy.ws;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.springframework.beans.factory.annotation.Autowired;

public class MessageApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	
	@Autowired
	private IRsMessage rsMessage;
	
	public MessageApplication() {
		singletons.add(rsMessage);
	}
 
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

	/**
	 * @return the rsMessage
	 */
	public IRsMessage getRsMessage() {
		return rsMessage;
	}

	/**
	 * @param rsMessage the rsMessage to set
	 */
	public void setRsMessage(IRsMessage rsMessage) {
		this.rsMessage = rsMessage;
	}
}
