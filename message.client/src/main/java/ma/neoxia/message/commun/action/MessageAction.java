package ma.neoxia.message.commun.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class MessageAction extends ActionSupport implements RequestAware, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3926204318583251403L;
	
	protected Map<String, Object> sessions;
	protected Map<String, Object> request;
	
	
	
	

	public Map<String, Object> getSessions() {
		return sessions;
	}

	public void setSessions(Map<String, Object> sessions) {
		this.sessions = sessions;
	}

	

	public Map<String, Object> getRequest() {
		return request;
	}

	@Override
	public void setSession(Map<String, Object> sessions) {
		this.sessions = sessions;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

}
