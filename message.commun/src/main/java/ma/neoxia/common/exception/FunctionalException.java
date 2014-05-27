package ma.neoxia.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FunctionalException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5935146453342502637L;

	private static final Logger log =  LoggerFactory.getLogger(FunctionalException.class);

	public FunctionalException() {
		super();
		log.error("FunctionalException");
	}

	public FunctionalException(String message, Throwable cause) {
		super(message, cause);
		log.error(message,cause);
	}

	public FunctionalException(String message) {
		super(message);	
		log.error(message);
	}

	public FunctionalException(Throwable cause) {
		super(cause);
		log.error("",cause);
	}

}
