package ma.ael.message.actions;

import ma.ael.message.commun.action.MessageAction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccueilAction extends MessageAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5493895518741349394L;
	private final static Logger log = LoggerFactory.getLogger(AccueilAction.class);
	

	public String index() {
		log.info( "AccueilAction Index !" );
		return SUCCESS;
	}

	public String login() {
		log.info( "AccueilAction Login !" );
		return SUCCESS;
	}
	
	@Override
	public String execute() throws Exception {
		log.info( "AccueilAction execute !" );
		// list des objets de test
		return SUCCESS;
	}
	
}
