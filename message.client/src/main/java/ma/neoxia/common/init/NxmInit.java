package ma.neoxia.common.init;

import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import ma.neoxia.common.utils.NxmStatics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class NxmInit extends HttpServlet {

	private static Logger log = LoggerFactory.getLogger(NxmInit.class);
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 3137491161037302273L;

	@Override
	public void init() throws ServletException {
		super.init();
		log.info("\n" +
				"\t\t====================================================================\n" +
				"\t\t         Starting "+NxmStatics.SYSNAME+" at: " + Calendar.getInstance().getTime() + "\n" +
				"\t\t         Version " + NxmStatics.VERSION + "\n" +
				"\t\t====================================================================" +
				"");
		//
	}
	@Override
	public void destroy() {
		super.destroy();
		log.info("\n" +
				"\t\t====================================================================\n" +
				"\t\t         Stoping "+NxmStatics.SYSNAME+" at: " + Calendar.getInstance().getTime() + "\n" +
				"\t\t         Version " + NxmStatics.VERSION + "\n" +
				"\t\t====================================================================" +
				"");
	}
	

}
