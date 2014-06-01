package ma.ael.repport.jasper.exception;

import ma.ael.common.exception.TechnicalException;


public class ReportingException extends TechnicalException
{

    private static final long serialVersionUID = 0xb56b22ae108936ccL;

    public ReportingException()
    {
    }

    public ReportingException(String message)
    {
        super(message);
    }

    public ReportingException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ReportingException(Throwable cause)
    {
        super(cause);
    }
}
