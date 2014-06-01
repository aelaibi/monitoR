package ma.ael.message.actions.reporting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import ma.ael.message.actions.Value;
import ma.ael.message.actions.base.JsonBaseAction;
import ma.ael.message.entities.Application;
import ma.ael.message.entities.Message;
import ma.ael.message.service.ApplicationService;
import ma.ael.message.service.MessageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class reportingAction extends JsonBaseAction {

	/**
	 * 
	 */
	@Autowired
	private ApplicationService applicationService;
	@Autowired
	private MessageService messageService;
	
	
	private static final long serialVersionUID = -5888639569828416834L;
	private final static Logger LOOGER = LoggerFactory.getLogger(reportingAction.class);
	private String application;
	private  Date firstDate;
	private  Date lastDate;
	private List<String> timesChart1;
	private List<ChartObject> charts1;
	
	
	public List<ChartObject> getCharts1() {
		return charts1;
	}
	public void setCharts1(List<ChartObject> charts1) {
		this.charts1 = charts1;
	}
	public Date getFirstDate() {
		return firstDate;
	}
	public List<String> getTimesChart1() {
		return timesChart1;
	}
	public void setTimesChart1(List<String> timesChart1) {
		this.timesChart1 = timesChart1;
	}
	public void setFirstDate(Date firstDate) {
		this.firstDate = firstDate;
	}
	public Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application = application;
	}
	public String index() {
		
		LOOGER.info( "reportingAction Index !" );
		return SUCCESS;
	}
	public String displayRapports()
	{	
		return SUCCESS;
	}
	
	public Collection<Value> getAllApps() {
		Collection<Value> apps = new Vector<Value>();
        List<String> types=messageService.findDistinctTypes();		
		
		
		
		
		List<Application> selectApps=new ArrayList<Application>();
				
		selectApps =	applicationService.findAll();
		
		for (Application app : selectApps) {
			Value value = new Value();
			value.setCode(app.getIdApplication().toString());
		    value.setLibelle(app.getNomApplication());
			apps.add(value);
		}
		return apps;
		}
public String getRapport1()
{LOOGER.info( "reportingAction getRapport1  Index !" );
	
List<Message> messages;

if(firstDate!=null&&lastDate!=null)
{
	messages=messageService.findByDateServerBetweenAndApplicationId(firstDate, lastDate, new Long(application)); 

}
else
{	 Date dd=new Date();
int hd=0;
dd.setHours(hd);
dd.setMinutes(hd);

Date df=new Date();
int hf=23;
int mf=59;
df.setHours(hf);
df.setMinutes(mf);				
messages=messageService.findByDateServerBetweenAndApplicationId(dd, df, new Long(application)); 

}


timesChart1=new ArrayList<String>();
for (Message message : messages) {
timesChart1.add(message.getDateServer().toString());	
}

return SUCCESS;


}


}
