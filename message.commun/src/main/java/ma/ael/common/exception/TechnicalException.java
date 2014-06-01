package ma.ael.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

public class TechnicalException extends DataAccessException {

	/**
	 *
	 */
	private static final long serialVersionUID = 4162611525544934718L;

	private final Logger log = LoggerFactory.getLogger(TechnicalException.class);

	
	
	public TechnicalException() {
		super("TechnicalException");
		log.error("TechnicalException");
	}

	public TechnicalException(String message, Throwable cause) {
		super(message, cause);
		log.error(message, cause);
	}

	public TechnicalException(String message) {
		super(message);
		log.error(message);
	}

	public TechnicalException(Throwable cause) {
		super(cause.getMessage(), cause);
		log.error("",cause);
	}

}
