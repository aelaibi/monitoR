package ma.neoxia.message.actions.ref;

import java.util.List;

import ma.neoxia.message.bean.ApplicationBean;
import ma.neoxia.message.bean.DomaineBean;
import ma.neoxia.message.commun.action.MessageAction;
import ma.neoxia.message.service.ApplicationService;
import ma.neoxia.message.service.DomaineService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class ApplicationDomaineAction extends MessageAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5493895518741349394L;
	private final static Logger LOOGER = LoggerFactory.getLogger(ApplicationDomaineAction.class);
	
	@Autowired
	private ApplicationService applicationService;
	@Autowired
	private DomaineService domaineService;
	
	private List<ApplicationBean> gridApplications;
	private List<DomaineBean> gridDomaines;
	
	
	/* requiered field to inline editing */
	private String id;
	private String oper;
	private String nomApplication;
	private String nomDomaine;
	private Long idSelectedApplication;
	private Long idDomaine;
	private Long idApplication;
	
	
	
	private Integer rows = 0;
	// Get the requested page. By default grid sets this to 1.
	private Integer page = 0;
	// sorting order - asc or desc
	private String sord;
	// get index row - i.e. user click to sort.
	private String sidx;
	// Your Total Pages
	private Integer total = 0;
	// All Record
	private Integer records = 0;
	
	
	public String index() {
		LOOGER.info( "index applicationDomaineAction " );
		return SUCCESS;
	}
	
	// application ::
	public String listApplication() {
		Pageable requestPage = new PageRequest(page-1, rows);
		gridApplications = ApplicationBean.fromList(applicationService.findAllByLimits(requestPage));
		records = (int) applicationService.count();
		total = (int) Math.ceil((double)records / (double)rows) ;
		LOOGER.info( "gridApplications size : " + gridApplications.size() );
		return SUCCESS;
	}
	
	public String applicationEdit() {
		if( oper.equalsIgnoreCase("edit") ) {
			LOOGER.info( "edit grid application! ");
			applicationService.editApplication(Long.valueOf(id), getNomApplication());
			
		} else if( oper.equalsIgnoreCase("add") ) {
			LOOGER.info( "add operation ");
			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setNomApplication(getNomApplication());
			applicationService.save(applicationBean);
			
		} else if( oper.equalsIgnoreCase("del") ) {
			LOOGER.info( "delete operation ");
			ApplicationBean tmpBean = new ApplicationBean();
			tmpBean.setIdApplication(Long.valueOf(id));
			applicationService.delete(tmpBean);
		}
		return SUCCESS;
	}
	
	// domaine ::
	public String listDomainesOfApplication() {
		if( idSelectedApplication != null ) {
			Pageable requestPage = new PageRequest(page-1, rows);
			getSessions().put("idOfApplication", idSelectedApplication);
			gridDomaines = DomaineBean.fromList(domaineService.findDomainesOfApplication(idSelectedApplication,requestPage));
			records = (int) domaineService.count();
			total = (int) Math.ceil((double)records / (double)rows) ;
			LOOGER.info( "gridDomaines size : " + gridDomaines.size() );
		}	
		return SUCCESS;
	}
	
	public String domaineEdit() {
		LOOGER.info(" domaine edit ");
		Long idApp = (Long) getSessions().get("idOfApplication");
		if( oper.equalsIgnoreCase("edit") ) {
			LOOGER.info( "edit grid domaine! ");
			domaineService.editDomaine(Long.valueOf(id), getNomDomaine());
		} else if( oper.equalsIgnoreCase("add") ) {
			LOOGER.info( "domaine add operation  ");
			DomaineBean domaineBean = new DomaineBean();
			domaineBean.setNomDomaine(getNomDomaine());
			domaineBean.setIdApplication(idApp);
			domaineService.save(domaineBean);
			
		} else if( oper.equalsIgnoreCase("del") ) {
			LOOGER.info("domaine delete operation ");
			DomaineBean domaineBean = new DomaineBean();
			domaineBean.setIdDomaine(Long.valueOf(id));
			domaineService.delete(domaineBean);
		}
		return SUCCESS;
	}
	
	
	public List<ApplicationBean> getGridApplications() {
		return gridApplications;
	}
	public void setGridApplications(List<ApplicationBean> gridApplications) {
		this.gridApplications = gridApplications;
	}

	public List<DomaineBean> getGridDomaines() {
		return gridDomaines;
	}
	public void setGridDomaines(List<DomaineBean> gridDomaines) {
		this.gridDomaines = gridDomaines;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}

	public String getNomApplication() {
		return nomApplication;
	}
	public void setNomApplication(String nomApplication) {
		this.nomApplication = nomApplication;
	}

	public Long getIdSelectedApplication() {
		return idSelectedApplication;
	}
	public void setIdSelectedApplication(Long idSelectedApplication) {
		this.idSelectedApplication = idSelectedApplication;
	}

	public Long getIdDomaine() {
		return idDomaine;
	}
	public void setIdDomaine(Long idDomaine) {
		this.idDomaine = idDomaine;
	}

	public String getNomDomaine() {
		return nomDomaine;
	}
	public void setNomDomaine(String nomDomaine) {
		this.nomDomaine = nomDomaine;
	}

	public Long getIdApplication() {
		return idApplication;
	}
	public void setIdApplication(Long idApplication) {
		this.idApplication = idApplication;
	}

	
	// added param for grid
	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getRecords() {
		return records;
	}

	public void setRecords(Integer records) {
		this.records = records;

		if (this.records > 0 && this.rows > 0)
		{
			this.total = (int) Math.ceil((double) this.records / (double) this.rows);
		}
		else
		{
			this.total = 0;
		}
	}	
}
